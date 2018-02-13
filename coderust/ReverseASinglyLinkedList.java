import common.LinkedListNode;

public class ReverseASinglyLinkedList {

    public static void main(String[] args) {

        LinkedListNode<Integer> node4 = new LinkedListNode<>(28, null);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(21, node4);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(14, node3);
        LinkedListNode<Integer> node1 = new LinkedListNode<>(7, node2);

        LinkedListNode reversed = reverseIterative(node1);

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

    private static LinkedListNode reverseIterative(LinkedListNode head) {
        // no need to reverse if head is null or there is only 1 node
        if (head == null || head.next == null) {
            return head;
        }

        LinkedListNode listToDo = head.next;
        LinkedListNode reversedList = head;

        reversedList.next = null;

        while (listToDo != null) {
            LinkedListNode temp = listToDo;
            listToDo = listToDo.next;

            temp.next = reversedList;

            reversedList = temp;
        }

        return reversedList;
    }
}
