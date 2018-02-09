package common;

public class BSTNode<T> {
    public T data;
    public BSTNode<T> left, right;

    public BSTNode() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

    public BSTNode(T data) {
        this.data = data;
    }

    public BSTNode(T data, BSTNode<T> left, BSTNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
