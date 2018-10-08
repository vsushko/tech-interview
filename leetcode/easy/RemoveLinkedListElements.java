package easy;

/**
 * 203. Remove Linked List Elements
 *
 * @author vsushko
 */
public class RemoveLinkedListElements {

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
        // 1->1
        ListNode node = new ListNode(1).next(new ListNode(1));
        node = removeElements(node, 1);
        print(node);

        // 1->2->6->3->4->5->6
        node = new ListNode(1)
                .next(new ListNode(2)
                        .next(new ListNode(6)
                                .next(new ListNode(3)
                                        .next(new ListNode(4)
                                                .next(new ListNode(5)
                                                        .next(new ListNode(6)))))));
        node = removeElements(node, 6);
        print(node);
    }

    private static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode node = new ListNode(0);
        node.next = head;

        ListNode prev = node;

        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return node.next;
    }

    private static void print(ListNode node) {
        if (node == null) {
            System.out.println("[]");
        } else {
            while (node.next != null) {
                System.out.print(node.val + " ");
                node = node.next;
            }
            System.out.println(node.val);
        }
    }
}


