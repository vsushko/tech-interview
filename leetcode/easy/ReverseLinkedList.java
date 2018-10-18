package easy;

/**
 * 206. Reverse Linked List
 *
 * @author vsushko
 */
public class ReverseLinkedList {

    public static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }

        ListNode next(ListNode node) {
            this.next = node;
            return this;
        }
    }

    public static void main(String[] args) {
        // 1->2->3
        ListNode node = new ListNode(1)
                .next(new ListNode(2).next(new ListNode(3)));
        print(node);
        node = reverseList(node);
        print(node);
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private static void print(ListNode node) {
        if (node == null) {
            System.out.println("[]");
        } else {
            while (node.next != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
            System.out.println(node.data);
        }
    }
}
