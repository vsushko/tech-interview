package common;

public class DoublyLinkedListNode<T> {
    public T data;
    public DoublyLinkedListNode<T> next;
    public DoublyLinkedListNode<T> prev;

    public DoublyLinkedListNode(T data) {
        this.data = data;
        next = null;
        prev = null;
    }

    public DoublyLinkedListNode(T data, DoublyLinkedListNode<T> next, DoublyLinkedListNode<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}