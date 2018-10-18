package easy;

/**
 * 160. Intersection of Two Linked Lists
 *
 * @author vsushko
 */
public class IntersectionOfTwoLinkedLists {

    private static class ListNode {
        int data;
        ListNode next;

        ListNode(int x) {
            data = x;
        }

        ListNode next(ListNode node) {
            this.next = node;
            return this;
        }
    }

    public static void main(String[] args) {
        ListNode intersectionNode = new ListNode(2);
        ListNode list1 = new ListNode(0).next(new ListNode(1).next(
                intersectionNode.next(new ListNode(3))));
        ListNode list2 = new ListNode(0).next(intersectionNode.next(new ListNode(4)));

        ListNode node = getIntersectionNode(list1, list2);
        System.out.println(node.data);
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int size1 = getSize(headA);
        int size2 = getSize(headB);

        while (size1 > size2) {
            headA = headA.next;
            size1--;
        }
        while (size1 < size2) {
            headB = headB.next;
            size2--;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private static int getSize(ListNode node) {
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
    }
}
