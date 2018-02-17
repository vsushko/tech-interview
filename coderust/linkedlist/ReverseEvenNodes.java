package linkedlist;


import common.LinkedListNode;
import utilities.LinkedListUtils;

/**
 * Given a singly linked list, reverse nodes at even indices.
 * <p>
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: Constant, O(1).
 */
public class ReverseEvenNodes {

    public static void main(String[] args) {
        LinkedListNode<Integer> node5 = new LinkedListNode<>(9, null);
        LinkedListNode<Integer> node4 = new LinkedListNode<>(28, node5);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(21, node4);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(14, node3);
        LinkedListNode<Integer> node1 = new LinkedListNode<>(7, node2);

        LinkedListUtils.printLinkedList(node1);

        LinkedListNode<Integer> head = reverseEvenNodes(node1);
        LinkedListUtils.printLinkedList(head);
    }

    // helper function to merge two lists
    private static LinkedListNode<Integer> mergeAlternating(LinkedListNode<Integer> list1,
                                                            LinkedListNode<Integer> list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        LinkedListNode<Integer> head = list1;

        while (list1.next != null && list2 != null) {
            LinkedListNode<Integer> temp = list2;
            list2 = list2.next;
            temp.next = list1.next;
            list1.next = temp;
            list1 = temp.next;
        }
        if (list1.next == null) {
            list1.next = list2;
        }
        return head;
    }

    private static LinkedListNode<Integer> reverseEvenNodes(LinkedListNode<Integer> head) {
        // let's extract even nodes from the existing list and create a new list
        // consisting of even node. We will push the even nodes at head since
        // we want them to be in reverse order
        LinkedListNode<Integer> curr = head;
        LinkedListNode<Integer> listEven = null;

        while (curr != null && curr.next != null) {
            LinkedListNode<Integer> even = curr.next;
            curr.next = even.next;
            // push at the head of new list
            even.next = listEven;
            listEven = even;

            curr = curr.next;
        }
        // now, merge the two lists original: 1,2,3,4,5; modified original 1,3,5;
        // list even: 4,2; merged: 1,4,3,2,5
        return mergeAlternating(head, listEven);
    }
}
