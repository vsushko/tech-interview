package utilities;

import common.LinkedListNode;

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

    public static int getLength(LinkedListNode head) {
        int listLength = 0;
        while (head != null) {
            head = head.next;
            listLength++;
        }
        return listLength;
    }
}
