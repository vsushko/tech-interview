package linkedlist;


import common.LinkedListNode;
import utilities.LinkedListUtils;

/**
 * Given head node of a singly linked list and an integer 'n', rotate linked list by 'n'.
 * <p>
 * Runtime Complexity: Linear, O(m), where 'm' is the length of linked list.
 * Memory Complexity: Constant, O(1).
 */
public class RotateALinkedList {

    public static void main(String[] args) {
        LinkedListNode<Integer> node6 = new LinkedListNode<>(6, null);
        LinkedListNode<Integer> node5 = new LinkedListNode<>(5, node6);
        LinkedListNode<Integer> node4 = new LinkedListNode<>(4, node5);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(3, node4);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(2, node3);
        LinkedListNode<Integer> node1 = new LinkedListNode<>(1, node2);

        LinkedListUtils.printLinkedList(node1);

        LinkedListNode<Integer> head = rotateList(node1, 2);
        LinkedListUtils.printLinkedList(head);
    }

    private static int findLength(LinkedListNode<Integer> head) {
        int len = 0;

        while (head != null) {
            ++len;
            head = head.next;
        }
        return len;
    }

    private static int adjustRotationsNeeded(int n, int len) {
        // if n is positive then number of rotations performed is from right side
        // and if n is negative then number of rotations performed from left side
        // let's optimize the number of rotations. Handle case if 'n' a negative number
        n = n % len;

        if (n < 0) {
            n = n + len;
        }
        return n;
    }

    private static LinkedListNode<Integer> rotateList(LinkedListNode<Integer> head, int n) {
        if (head == null || n == 0) {
            return head;
        }
        int len = findLength(head);

        // if n (number of rotations required) is bigger than length of linked list
        // or if n is negative then we need to adjust total number of rotations needed
        n = adjustRotationsNeeded(n, len);

        if (n == 0) {
            return head;
        }

        // find the start of rotated list. If we have 1,2,3,4,5 where n = 2,
        // 4 is the start of rotated list
        int rotationsCount = len - n - 1;
        LinkedListNode<Integer> temp = head;

        while (rotationsCount > 0) {
            rotationsCount--;
            temp = temp.next;
        }
        // after the above loop temp will be pointing to one node prior to rotation point
        LinkedListNode<Integer> newHead = temp.next;

        // set new end of list
        temp.next = null;

        // iterate to the end of list and link that to original head
        temp = newHead;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;

        return newHead;
    }


}
