package linkedlist;

import common.LinkedListNode;
import utilities.LinkedListUtils;

public class DeleteNodeWithAGivenKey {

    public static void main(String[] args) {
        LinkedListNode<Integer> node6 = new LinkedListNode<>(42, null);
        LinkedListNode<Integer> node5 = new LinkedListNode<>(35, node6);
        LinkedListNode<Integer> node4 = new LinkedListNode<>(28, node5);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(21, node4);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(14, node3);
        LinkedListNode<Integer> node1 = new LinkedListNode<>(7, node2);

        LinkedListUtils.printLinkedList(node1);

        LinkedListNode<Integer> listWithoutKey = deleteNode(node1, 28);
        LinkedListUtils.printLinkedList(listWithoutKey);
    }

    private static LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int key) {
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> current = head;

        while (current != null) {
            if (current.data == key) {
                break;
            }
            prev = current;
            current = current.next;
        }
        // key not found in list
        if (current == null) {
            return head;
        }
        // if node to be deleted is head node
        if (current == head) {
            return current.next;
        }
        // for all others cases
        prev.next = current.next;
        return head;
    }

}
