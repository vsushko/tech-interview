package linkedlist;

import common.LinkedListNode;
import utilities.LinkedListUtils;

import java.util.HashSet;

public class RemoveDuplicates {

    public static void main(String[] args) {
        LinkedListNode<Integer> node6 = new LinkedListNode<>(21, null);
        LinkedListNode<Integer> node5 = new LinkedListNode<>(14, node6);
        LinkedListNode<Integer> node4 = new LinkedListNode<>(28, node5);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(28, node4);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(14, node3);
        LinkedListNode<Integer> node1 = new LinkedListNode<>(7, node2);

        LinkedListUtils.printLinkedList(node1);

        LinkedListNode<Integer> head = removeDuplicates(node1);
        LinkedListUtils.printLinkedList(head);
    }

    private static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
        if (head == null) {
            return head;
        }

        // let's track list values in a hash table
        HashSet<Integer> dupSet = new HashSet<>();
        LinkedListNode<Integer> curr = head;
        dupSet.add(curr.data);

        while (curr.next != null) {
            if (!dupSet.contains(curr.next.data)) {
                // element not found in map, let's add it
                dupSet.add(curr.next.data);
                curr = curr.next;
            } else {
                // duplicate node found, let's remove it from the list
                curr.next = curr.next.next;
            }
        }
        return head;
    }
}
