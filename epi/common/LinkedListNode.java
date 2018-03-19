package common;

public class LinkedListNode<T> {
    public LinkedListNode<T> next;
    public T data;

    public LinkedListNode() {
        this.next = null;
        this.data = null;
    }

    public LinkedListNode(T data) {
        this.data = data;
    }

    public LinkedListNode(T data, LinkedListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public LinkedListNode(int key, T data) {
        this.data = data;
    }

    public void appendToTail(T data) {
        LinkedListNode<T> node = new LinkedListNode<>(data);
        LinkedListNode<T> current = this;

        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof LinkedListNode && ((LinkedListNode) obj).data == data;
    }


    @Override
    public int hashCode() {
        return data.hashCode();
    }


    public String toString() {
        LinkedListNode node = this;

        StringBuilder sb = new StringBuilder();

        while (node.next != null) {
            sb.append(node.data);
            sb.append("->");
            node = node.next;
        }
        sb.append(node.data);

        return sb.toString();
    }

}