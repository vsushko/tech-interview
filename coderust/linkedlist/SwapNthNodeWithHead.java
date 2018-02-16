package linkedlist;

import common.LinkedListNode;
import utilities.LinkedListUtils;

/**
 * Given the head of a singly linked list and 'N', swap the head with Nth node.
 * Return the head of the new linked list.
 */
public class SwapNthNodeWithHead {

    public static void main(String[] args) {
        LinkedListNode<Integer> node6 = new LinkedListNode<>(42, null);
        LinkedListNode<Integer> node5 = new LinkedListNode<>(35, node6);
        LinkedListNode<Integer> node4 = new LinkedListNode<>(28, node5);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(21, node4);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(14, node3);
        LinkedListNode<Integer> node1 = new LinkedListNode<>(7, node2);

        LinkedListUtils.printLinkedList(node1);

        LinkedListNode<Integer> head = swapNthNode(node1, 5);
        LinkedListUtils.printLinkedList(head);
    }

    // node indices starts from 1
    static LinkedListNode swapNthNode(LinkedListNode head, int n) {
        LinkedListNode prev = null;
        LinkedListNode current = head;

        if (head == null) {
            return head;
        }
        if (n == 1) {
            // no need to swap head with head
            return head;
        }
        for (int count = 1; current != null && count < n; count++) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            return head;
        }
        // current is pointing to nth node, let's swap nth node with head
        prev.next = head;
        LinkedListNode temp = head.next;
        head.next = current.next;
        current.next = temp;
        return current;
    }

}
