package linkedlist;

import common.LinkedListNode;
import utilities.LinkedListUtils;

public class NthFromLastNode {

    public static void main(String[] args) {
        LinkedListNode<Integer> node6 = new LinkedListNode<>(42, null);
        LinkedListNode<Integer> node5 = new LinkedListNode<>(35, node6);
        LinkedListNode<Integer> node4 = new LinkedListNode<>(28, node5);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(21, node4);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(14, node3);
        LinkedListNode<Integer> node1 = new LinkedListNode<>(7, node2);

        LinkedListUtils.printLinkedList(node1);

        LinkedListNode<Integer> head = findNthFromLast(node1, 3);
        LinkedListUtils.printLinkedList(head);
    }

    private static LinkedListNode<Integer> findNthFromLast(LinkedListNode<Integer> head,
                                                           int n) {
        if (head == null || n < 1) {
            return null;
        }
        // we will use two pointers head and tail where head and tail are 'n' nodes apart
        LinkedListNode<Integer> tail = head;

        while (tail != null && n > 0) {
            tail = tail.next;
            --n;
        }

        if (n != 0) {
            return null;
        }
        // when tail pointer reaches the end of list, head is pointing at nth node
        while (tail != null) {
            tail = tail.next;
            head = head.next;
        }
        return head;
    }
}
