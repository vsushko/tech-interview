package linkedlist;

import common.LinkedListNode;
import utilities.LinkedListUtils;

public class InsertionSortOfALinkedList {

    public static void main(String[] args) {
        LinkedListNode<Integer> node4 = new LinkedListNode<>(11, null);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(82, node4);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(23, node3);
        LinkedListNode<Integer> node1 = new LinkedListNode<>(29, node2);

        LinkedListUtils.printLinkedList(node1);

        LinkedListNode<Integer> head = insertionSort(node1);
        LinkedListUtils.printLinkedList(head);
    }

    private static LinkedListNode<Integer> sortedInsert(LinkedListNode<Integer> head,
                                                        LinkedListNode<Integer> node) {
        if (node == null) {
            return head;
        }

        if (head == null || node.data <= head.data) {
            node.next = head;
            return node;
        }

        LinkedListNode<Integer> curr = head;

        while (curr.next != null && (curr.next.data < node.data)) {
            curr = curr.next;
        }
        node.next = curr.next;
        curr.next = node;

        return head;
    }

    public static LinkedListNode<Integer> insertionSort(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> sorted = null;
        LinkedListNode<Integer> curr = head;

        while (curr != null) {
            LinkedListNode<Integer> temp = curr.next;
            sorted = sortedInsert(sorted, curr);
            curr = temp;
        }
        return sorted;
    }
}
