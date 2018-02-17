package linkedlist;

import common.LinkedListNode;
import utilities.LinkedListUtils;

/**
 * Given a singly linked list and an integer 'k', reverse every 'k' elements.
 * If k <= 1, then input list is unchanged. If k >= n (n is the length of linked list),
 * then reverse the whole linked list.
 * <p>
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: Constant, O(1).
 */
public class ReverseKElements {

    public static void main(String[] args) {
        LinkedListNode<Integer> node6 = new LinkedListNode<>(6, null);
        LinkedListNode<Integer> node5 = new LinkedListNode<>(5, node6);
        LinkedListNode<Integer> node4 = new LinkedListNode<>(4, node5);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(3, node4);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(2, node3);
        LinkedListNode<Integer> node1 = new LinkedListNode<>(1, node2);

        LinkedListUtils.printLinkedList(node1);

        LinkedListNode<Integer> head = reverseKNodes(node1, 3);
        LinkedListUtils.printLinkedList(head);
    }

    private static LinkedListNode<Integer> reverseKNodes(
            LinkedListNode<Integer> head, int k) {
        // if k is 0 of 1, then list is not changed
        if (k <= 1 || head == null) {
            return head;
        }
        LinkedListNode<Integer> reversed = null;
        LinkedListNode<Integer> prevTail = null;

        while (head != null && k > 0) {
            LinkedListNode<Integer> currentHead = null;
            LinkedListNode<Integer> currentTail = head;

            int n = k;
            while (head != null && n > 0) {
                LinkedListNode<Integer> temp = head.next;
                head.next = currentHead;
                currentHead = head;

                head = temp;
                n--;
            }
            if (reversed == null) {
                reversed = currentHead;
            }
            if (prevTail != null) {
                prevTail.next = currentHead;
            }
            prevTail = currentTail;
        }
        return reversed;
    }
}
