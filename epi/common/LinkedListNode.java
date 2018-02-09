package common;

/**
 * A class for nodes
 *
 * @author Xijie Guo
 */
public class LinkedListNode<T> {

    //An instance variable representing data stored in this node
    protected T data;

    //An instance variable representing the next node in the linked list
    protected LinkedListNode<T> next;

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
     * Get the data stored at this node.
     */
    public T getData() {
        return data;
    }

    /**
     * Set the data stored at this node.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Get (pointer to) next node.
     */
    public LinkedListNode<T> getNext() {
        return next;
    }

    /**
     * Set the next pointer to passed node.
     */
    public void setNext(LinkedListNode<T> node) {
        this.next = node;
    }

    /**
     * Returns a String representation of this node.
     */
    public String toString() {
        return data.toString();
    }

}