package common;

public class LinkedListNode<T> {
    public LinkedListNode<T> next;
    public T data;

    public LinkedListNode(T data) {
        this.data = data;
    }

    public LinkedListNode(T data, LinkedListNode<T> next) {
        this.data = data;
        this.next = next;
    }

}