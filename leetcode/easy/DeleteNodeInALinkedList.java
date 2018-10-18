package easy;

/**
 * 237. Delete Node in a Linked List
 *
 * @author vsushko
 */
public class DeleteNodeInALinkedList {

    static class ListNode {
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

    private static ListNode node;

    public static void main(String[] args) {
        ListNode nodeToDelete = new ListNode(2);
        node = new ListNode(1).next(nodeToDelete.next(new ListNode(3)));
        deleteNode(nodeToDelete);

        ListNode current = node;
        System.out.print(current.val);
        while (current.next != null) {
            current = current.next;
            System.out.print(" " + current.val);
        }
    }

    private static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
