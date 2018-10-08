package easy;

/**
 * 141. Linked List Cycle
 *
 * @author vsushko
 */
public class LinkedListCycle {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode next(ListNode node) {
            this.next = node;
            return this;
        }
    }

    public static void main(String[] args) {
        ListNode cycledElement = new ListNode(3);
        ListNode node = new ListNode(1).next(new ListNode(2).next(
                cycledElement.next(new ListNode(4).next(new ListNode(5).next(cycledElement)))));
        System.out.println("Has cycle: " + hasCycle(node));
    }

    private static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
