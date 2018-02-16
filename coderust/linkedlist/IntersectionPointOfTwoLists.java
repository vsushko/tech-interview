package linkedlist;

import common.LinkedListNode;
import utilities.LinkedListUtils;

public class IntersectionPointOfTwoLists {

    public static void main(String[] args) {
        LinkedListNode node16 = new LinkedListNode(27, null);
        LinkedListNode node15 = new LinkedListNode(12, node16);
        LinkedListNode node14 = new LinkedListNode(11, node15);
        LinkedListNode node13 = new LinkedListNode(82, node14);
        LinkedListNode node12 = new LinkedListNode(23, node13);
        LinkedListNode node11 = new LinkedListNode(29, node12);

        LinkedListNode node24 = new LinkedListNode(27, null);
        LinkedListNode node23 = new LinkedListNode(12, node24);
        LinkedListNode node22 = new LinkedListNode(4, node23);
        LinkedListNode node21 = new LinkedListNode(13, node22);

        LinkedListNode intersectedList = intersect(node11, node21);
        LinkedListUtils.printLinkedList(intersectedList);
    }

    private static LinkedListNode intersect(LinkedListNode head1,
                                                     LinkedListNode head2) {
        LinkedListNode list1node;
        int list1length = LinkedListUtils.getLength(head1);
        LinkedListNode list2node;
        int list2length = LinkedListUtils.getLength(head2);

        int lengthDifference;

        if (list1length >= list2length) {
            lengthDifference = list1length - list2length;
            list1node = head1;
            list2node = head2;
        } else {
            lengthDifference = list2length - list1length;
            list1node = head2;
            list2node = head1;
        }
        while (lengthDifference > 0) {
            list1node = list1node.next;
            lengthDifference--;
        }
        while (list1node != null) {
            if (list1node.toString().equals(list2node.toString())) {
                return list1node;
            }
            list1node = list1node.next;
            list2node = list2node.next;
        }
        return null;
    }
}
