package linkedlist;

import common.LinkedListNode;
import utilities.LinkedListUtils;

/**
 * Given two sorted linked lists, merge them such that resulting linked list is also sorted.
 */
public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) {
        LinkedListNode<Integer> node14 = new LinkedListNode<>(19, null);
        LinkedListNode<Integer> node13 = new LinkedListNode<>(15, node14);
        LinkedListNode<Integer> node12 = new LinkedListNode<>(8, node13);
        LinkedListNode<Integer> node11 = new LinkedListNode<>(4, node12);

        LinkedListNode<Integer> node24 = new LinkedListNode<>(16, null);
        LinkedListNode<Integer> node23 = new LinkedListNode<>(10, node24);
        LinkedListNode<Integer> node22 = new LinkedListNode<>(9, node23);
        LinkedListNode<Integer> node21 = new LinkedListNode<>(7, node22);

        LinkedListNode intersectedList = mergeSorted(node11, node21);
        LinkedListUtils.printLinkedList(intersectedList);
    }

    private static LinkedListNode mergeSorted(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        // if both lists are empty then merged list is also empty
        // if one of the lists is empty then other is the merged list
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        LinkedListNode<Integer> mergedHead;
        if (head1.data <= head2.data) {
            mergedHead = head1;
            head1 = head1.next;
        } else {
            mergedHead = head2;
            head2 = head2.next;
        }
        LinkedListNode<Integer> mergedTail = mergedHead;

        while (head1 != null && head2 != null) {
            LinkedListNode<Integer> temp;
            if (head1.data < head2.data) {
                temp = head1;
                head1 = head1.next;
            } else {
                temp = head2;
                head2 = head2.next;
            }
            mergedTail.next = temp;
            mergedTail = temp;
        }
        if (head1 != null) {
            mergedTail.next = head1;
        } else if (head2 != null) {
            mergedTail.next = head2;
        }
        return mergedHead;
    }
}
