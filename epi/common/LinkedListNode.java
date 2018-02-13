package common;

/**
 * A class for nodes
 *
 * @author Xijie Guo
 */
public class LinkedListNode<T> {

    //An instance variable representing the next node in the linked list
    public LinkedListNode<T> next;
    //An instance variable representing data stored in this node
    public T data;

    public LinkedListNode(T data) {
        this.data = data;
    }

    /**
     * Constructor of the linked list node
     *
     * @param data for data stored in this node
     * @param next for the next node in the linked list
     */
    public LinkedListNode(T data, LinkedListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Returns a String representation of this node.
     */
    public String toString() {
        return data.toString();
    }

}