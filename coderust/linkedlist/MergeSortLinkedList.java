package linkedlist;

import common.LinkedListNode;
import common.Pair;
import utilities.LinkedListUtils;

/**
 * Given head pointer of a linked sort, sort linked list (in ascending order)
 * using merge sort and return new head pointer of sorted linked list.
 * <p>
 * Runtime Complexity: Linearithmic i.e. O(n * log n)
 * Memory Complexity: Logarithmic, O(log n).
 * <p>
 * Recursive solution has O(log n) memory complexity as it will consume memory on the stack
 */
public class MergeSortLinkedList {

    public static void main(String[] args) {
        LinkedListNode<Integer> node7 = new LinkedListNode<>(21, null);
        LinkedListNode<Integer> node6 = new LinkedListNode<>(3, node7);
        LinkedListNode<Integer> node5 = new LinkedListNode<>(4, node6);
        LinkedListNode<Integer> node4 = new LinkedListNode<>(11, node5);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(82, node4);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(23, node3);
        LinkedListNode<Integer> node1 = new LinkedListNode<>(29, node2);

        LinkedListUtils.printLinkedList(node1);

        LinkedListNode<Integer> head = mergeSort(node1);
        LinkedListUtils.printLinkedList(head);
    }

    private static void splitInHalf(LinkedListNode<Integer> head,
                                   Pair<LinkedListNode<Integer>, LinkedListNode<Integer>> firstSecond) {
        if (head == null) {
            return;
        }
        // only one element in the list
        if (head.next == null) {
            firstSecond.first = head;
            firstSecond.second = null;
        } else {
            // let's use the classic technique of moving two pointers: fast and 'slow'
            // fast will move two steps in each iteration where 'slow' will be pointing
            // to the middle element the end of loop
            LinkedListNode<Integer> slow, fast;
            slow = head;
            fast = head.next;

            while (fast != null) {
                fast = fast.next;
                if (fast != null) {
                    fast = fast.next;
                    slow = slow.next;
                }
            }
            firstSecond.first = head;
            firstSecond.second = slow.next;
            // terminate first linked list
            slow.next = null;
        }
    }

    private static LinkedListNode<Integer> mergeSortedLists(LinkedListNode<Integer> first,
                                                            LinkedListNode<Integer> second) {
        if (first == null) {
            return second;
        } else if (second == null) {
            return first;
        }

        LinkedListNode<Integer> newHead;

        if (first.data < second.data) {
            newHead = first;
            first = first.next;
        } else {
            newHead = second;
            second = second.next;
        }

        LinkedListNode<Integer> newCurrent = newHead;

        while (first != null && second != null) {
            LinkedListNode<Integer> temp;
            if (first.data <= second.data) {
                temp = first;
                first = first.next;
            } else {
                temp = second;
                second = second.next;
            }
            newCurrent.next = temp;
            newCurrent = temp;
        }

        if (first != null) {
            newCurrent.next = first;
        } else if (second != null) {
            newCurrent.next = second;
        }
        return newHead;
    }

    private static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
        // no need to sort a single element
        if (head == null || head.next == null) {
            return head;
        }
        Pair<LinkedListNode<Integer>, LinkedListNode<Integer>> firstSecond =
                new Pair<>(null, null);

        // let's split the list in half, sort the sublists and then merge the sorted lists
        splitInHalf(head, firstSecond);
        firstSecond.first = mergeSort(firstSecond.first);
        firstSecond.second = mergeSort(firstSecond.second);

        return mergeSortedLists(firstSecond.first, firstSecond.second);
    }
}
