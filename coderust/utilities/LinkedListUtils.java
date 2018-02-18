package utilities;

import common.LinkedListNode;
import common.LinkedListNodeWithArbitraryPointer;

public final class LinkedListUtils {

    private LinkedListUtils() {
        super();
    }

    public static void printLinkedList(LinkedListNode reversed) {
        StringBuilder stringBuilder = new StringBuilder();
        LinkedListNode current = reversed;
        while (current != null) {
            stringBuilder.append(current.data);
            if (current.next != null) {
                stringBuilder.append("->");
            }
            current = current.next;
        }
        System.out.println(stringBuilder.toString());
    }

    public static void printLinkedList(LinkedListNodeWithArbitraryPointer reversed) {
        StringBuilder stringBuilder = new StringBuilder();
        LinkedListNodeWithArbitraryPointer current = reversed;
        while (current != null) {
            stringBuilder.append(current.data);
            if (current.next != null) {
                stringBuilder.append('(').append(current.arbitraryPointer).append(')').append("->");
            } else {
                stringBuilder.append('(').append(current.arbitraryPointer == null
                        ? null : current.arbitraryPointer.data).append(')');
            }
            current = current.next;
        }
        System.out.println(stringBuilder.toString());
    }

    public static int getLength(LinkedListNode head) {
        int listLength = 0;
        while (head != null) {
            head = head.next;
            listLength++;
        }
        return listLength;
    }
}
