package linkedlist;

import common.LinkedListNode;
import utilities.LinkedListUtils;

/**
 * Given head pointers of two linked lists where each linked list
 * represents an integer number (each node is a digit), add them
 * and return the resulting linked list.
 * <p>
 * Runtime Complexity: Linear, O(n)
 * Runtime complexity is based on the length of the linked lists.
 * Memory Complexity: Constant, O(1)
 */
public class AddTwoIntegers {

    public static void main(String[] args) {
        LinkedListNode<Integer> node14 = new LinkedListNode<>(9, null);
        LinkedListNode<Integer> node13 = new LinkedListNode<>(9, node14);
        LinkedListNode<Integer> node12 = new LinkedListNode<>(0, node13);
        LinkedListNode<Integer> node11 = new LinkedListNode<>(1, node12);

        LinkedListNode<Integer> node23 = new LinkedListNode<>(2, null);
        LinkedListNode<Integer> node22 = new LinkedListNode<>(3, node23);
        LinkedListNode<Integer> node21 = new LinkedListNode<>(7, node22);

        LinkedListNode intersectedList = addIntegers(node11, node21);
        LinkedListUtils.printLinkedList(intersectedList);
    }

    private static LinkedListNode<Integer> addIntegers(LinkedListNode<Integer> integer1,
                                                       LinkedListNode<Integer> integer2) {
        LinkedListNode<Integer> result = null;
        LinkedListNode<Integer> last = null;
        int carry = 0;

        while (integer1 != null || integer2 != null || carry > 0) {
            int first = (integer1 == null ? 0 : integer1.data);
            int second = (integer2 == null ? 0 : integer2.data);
            int sum = first + second + carry;

            LinkedListNode<Integer> pNew = new LinkedListNode<>(sum % 10);
            carry = sum / 10;

            if (result == null) {
                result = pNew;
            } else {
                last.next = pNew;
            }
            last = pNew;
            if (integer1 != null) {
                integer1 = integer1.next;
            }
            if (integer2 != null) {
                integer2 = integer2.next;
            }
        }
        return result;
    }
}
