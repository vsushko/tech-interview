package easy;

import java.util.HashSet;

/**
 * 83. Remove Duplicates from Sorted List
 *
 * @author vsushko
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode l13 = new ListNode(2);
        ListNode l12 = new ListNode(1);
        ListNode l1 = new ListNode(1);
        l1.next = l12;
        l12.next = l13;

        ListNode l25 = new ListNode(3);
        ListNode l24 = new ListNode(3);
        ListNode l23 = new ListNode(2);
        ListNode l22 = new ListNode(1);
        ListNode l21 = new ListNode(1);
        l21.next = l22;
        l22.next = l23;
        l23.next = l24;
        l24.next = l25;

        System.out.println("Approach with using HashSet");
        ListNode listNode = deleteDuplicatesHS(l1);

        System.out.print(listNode.val + "->");
        while (listNode.next != null) {
            listNode = listNode.next;
            System.out.print(listNode.val + "->");
        }
        System.out.println();
        listNode = deleteDuplicatesHS(l21);

        System.out.print(listNode.val + "->");
        while (listNode.next != null) {
            listNode = listNode.next;
            System.out.print(listNode.val + "->");
        }

        System.out.println("\nStraight-Forward Approach");
        listNode = deleteDuplicatesSF(l1);

        System.out.print(listNode.val + "->");
        while (listNode.next != null) {
            listNode = listNode.next;
            System.out.print(listNode.val + "->");
        }
        System.out.println();
        listNode = deleteDuplicatesSF(l21);

        System.out.print(listNode.val + "->");
        while (listNode.next != null) {
            listNode = listNode.next;
            System.out.print(listNode.val + "->");
        }
    }

    /**
     * Approach 1: Straight-Forward Approach
     * <p>
     * Time complexity : O(n), because each node in the list is checked exactly
     * once to determine if it is a duplicate or not, the total run time
     * is O(n), where n is the number of nodes in the list
     * Space complexity : O(1), no additional space is used
     */
    private static ListNode deleteDuplicatesSF(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    /**
     * Approach 2: Approach with using HashSet
     * <p>
     * Runtime Complexity: Linear, O(n) - where 'n' is length of the linked list
     * Memory Complexity: Linear, O(n) - to store visited nodes in hashset
     */
    private static ListNode deleteDuplicatesHS(ListNode head) {
        if (head == null) {
            return head;
        }

        // lets's track list values in a hash table
        HashSet<Integer> duplications = new HashSet<>();
        ListNode current = head;
        duplications.add(current.val);

        while (current.next != null) {
            if (!duplications.contains(current.next.val)) {
                // element not found in map, let's add it
                duplications.add(current.next.val);
                current = current.next;
            } else {
                // duplicate node found, let's remove it from the list
                current.next = current.next.next;
            }
        }
        return head;
    }
}