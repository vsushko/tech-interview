package common;

public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> parent, left, right, next;

    public BinaryTreeNode() {
        this.data = null;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode(T data) {
        this.data = data;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.data = data;
        this.parent = null;
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right, BinaryTreeNode<T> parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTreeNode<T> getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNode<T> parent) {
        this.parent = parent;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

}
