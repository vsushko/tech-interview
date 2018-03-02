package trees;

import common.BinaryTreeNode;

/**
 * Inorder successor of a node in binary tree is the next node in inorder traversal.
 * Write a method to find inorder successor of a given binary tree node in
 * binary search tree given parent pointers.
 * <p>
 * Runtime Complexity: Logarithmic, O(logn).
 * Memory Complexity: Constant, O(1).
 */
public class InorderSuccessorBSTWithParentPointer {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> l1 = new BinaryTreeNode<>(50);
        l1.setLeft(new BinaryTreeNode<>(25));
        l1.setRight(new BinaryTreeNode<>(75));
        BinaryTreeNode<Integer> r1 = new BinaryTreeNode<>(200);
        r1.setLeft(new BinaryTreeNode<>(125));
        r1.setRight(new BinaryTreeNode<>(350));
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(100, l1, r1);

        BinaryTreeNode successor = findSuccessor(root, 25);
        System.out.println("inorder successor of 25 is " + (successor == null ? "NULL" : successor.data));
        successor = findSuccessor(root, 50);
        System.out.println("inorder successor of 50 is " + (successor == null ? "NULL" : successor.data));
        successor = findSuccessor(root, 75);
        System.out.println("inorder successor of 75 is " + (successor == null ? "NULL" : successor.data));
        successor = findSuccessor(root, 100);
        System.out.println("inorder successor of 100 is " + (successor == null ? "NULL" : successor.data));
        successor = findSuccessor(root, 125);
        System.out.println("inorder successor of 125 is " + (successor == null ? "NULL" : successor.data));
        successor = findSuccessor(root, 200);
        System.out.println("inorder successor of 200 is " + (successor == null ? "NULL" : successor.data));
        successor = findSuccessor(root, 350);
        System.out.println("inorder successor of 350 is " + (successor == null ? "NULL" : successor.data));
    }

    private static BinaryTreeNode findMinInTree(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }

        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private static BinaryTreeNode inorderSuccessorBSTParentPointer(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return findMinInTree(node.right);
        }
        while (node.parent != null) {
            if (node.parent.left == node) {
                return node.parent;
            }
            node = node.parent;
        }
        return null;
    }

    private static BinaryTreeNode findSuccessor(BinaryTreeNode root, int d) {
        while (root != null) {
            if ((int) root.data < d) {
                root = root.right;
            } else if ((int) root.data > d) {
                root = root.left;
            } else {
                return inorderSuccessorBSTParentPointer(root);
            }
        }
        return null;
    }
}
