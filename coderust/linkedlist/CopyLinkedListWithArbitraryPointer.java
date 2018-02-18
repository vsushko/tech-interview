package linkedlist;

import common.LinkedListNodeWithArbitraryPointer;
import utilities.LinkedListUtils;

import java.util.Hashtable;

/**
 * Make a deep copy of the given linked list with each node having two pointers:
 * 'next' and 'arbitrary_pointer'.
 * <p>
 * Solution #1:
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: Linear, O(n).
 */
public class CopyLinkedListWithArbitraryPointer {

    public static void main(String[] args) {
        LinkedListNodeWithArbitraryPointer<Integer> node3 = new LinkedListNodeWithArbitraryPointer<>(21, null);
        LinkedListNodeWithArbitraryPointer<Integer> node2 = new LinkedListNodeWithArbitraryPointer<>(14, node3, null);
        LinkedListNodeWithArbitraryPointer<Integer> node1 = new LinkedListNodeWithArbitraryPointer<>(7, node2, node3);
        node3.arbitraryPointer = node1;

        LinkedListUtils.printLinkedList(node1);

        LinkedListNodeWithArbitraryPointer<Integer> head = deepCopyArbitraryPointer(node1);
        LinkedListUtils.printLinkedList(head);
    }

    private static LinkedListNodeWithArbitraryPointer<Integer> deepCopyArbitraryPointer(
            LinkedListNodeWithArbitraryPointer<Integer> head) {
        if (head == null) {
            return null;
        }
        LinkedListNodeWithArbitraryPointer<Integer> current = head;
        LinkedListNodeWithArbitraryPointer<Integer> newHead = null;
        LinkedListNodeWithArbitraryPointer<Integer> newPrev = null;
        Hashtable<LinkedListNodeWithArbitraryPointer<Integer>, LinkedListNodeWithArbitraryPointer<Integer>> map =
                new Hashtable<>();

        // create copy of the linked list, recording the corresponding nodes
        // in hashmap without updating arbitrary pointer
        while (current != null) {
            LinkedListNodeWithArbitraryPointer<Integer> newNode =
                    new LinkedListNodeWithArbitraryPointer<>(current.data);

            // copy the old arbitrary pointer in the new node
            newNode.arbitraryPointer = current.arbitraryPointer;
            if (newPrev != null) {
                newPrev.next = newNode;
            } else {
                newHead = newNode;
            }
            map.put(current, newNode);

            newPrev = newNode;
            current = current.next;
        }
        LinkedListNodeWithArbitraryPointer<Integer> newCurrent = newHead;

        // updating arbitrary pointer
        while (newCurrent != null) {
            if (newCurrent.arbitraryPointer != null) {
                LinkedListNodeWithArbitraryPointer<Integer> node =
                        map.get(newCurrent.arbitraryPointer);
                newCurrent.arbitraryPointer = node;
            }
            newCurrent = newCurrent.next;
        }
        return newHead;
    }
}
