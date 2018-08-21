package easy;

/**
 * 21. Merged Two Sorted Lists
 *
 * @author vsushko
 */
public class MergedTwoSortedLists {

    public static void main(String[] args) {
        ListNode l13 = new ListNode(4);
        ListNode l12 = new ListNode(2);
        ListNode l1 = new ListNode(1);
        l1.next = l12;
        l12.next = l13;

        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(3);
        ListNode l2 = new ListNode(1);
        l2.next = l22;
        l22.next = l23;

        System.out.println("Recursive merge");
        ListNode nodeR = mergeTwoListsRec(l1, l2);

        System.out.print(nodeR.val + "->");
        while (nodeR.next != null) {
            nodeR = nodeR.next;
            System.out.print(nodeR.val + "->");
        }

        System.out.println("\nIteration merge");

        ListNode nodeI = mergeTwoListsIter(l1, l2);

        System.out.print(nodeI.val + "->");
        while (nodeI.next != null) {
            nodeI = nodeI.next;
            System.out.print(nodeI.val + "->");
        }
    }

    /**
     * Approach 1: Recursion
     * <p>
     * Time complexity: O(n+m), there will be exactly one call mergeTwoListsRec
     * per element in each list, hence the time complexity is linear
     * Space complexity: O(n+m), n+m stack frames consume O(n+m) space
     */
    private static ListNode mergeTwoListsRec(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoListsRec(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRec(l1, l2.next);
            return l2;
        }
    }

    /**
     * Approach 2: Iteration
     * <p>
     * Time complexity: O(n+m), because exactly one of l1 and l2
     * is incremented on each loop iteration
     * Space complexity: O(1)
     */
    private static ListNode mergeTwoListsIter(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node
        ListNode preHead = new ListNode(-1);

        ListNode prev = preHead;

        // TODO: fix the infinite loop
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list
        prev.next = l1 == null ? l2 : l1;

        return preHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }
}