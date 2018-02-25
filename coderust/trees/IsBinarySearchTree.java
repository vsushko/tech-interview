package trees;

import common.BinaryTreeNode;
import utilities.BTreePrinter;

/**
 * Given a binary tree, figure out whether it's a BST.
 * <p>
 * Solution #1
 * Runtime Complexity: Linear, O(n)
 * Memory Complexity: O(h).
 * <p>
 * Solution #2
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: O(h).
 * <p>
 * Recursive solution has O(h) memory complexity as it will consume memory on the stack
 * up to the height of binary tree h. It will be O(log n) for a balanced tree
 * and in the worst case can be O(n).
 */
public class IsBinarySearchTree {

    private static BinaryTreeNode prev;

    public static void main(String[] args) {
        BinaryTreeNode<Integer> l1 = new BinaryTreeNode<>(50);
        l1.setLeft(new BinaryTreeNode<>(25));
        l1.setRight(new BinaryTreeNode<>(75));
        BinaryTreeNode<Integer> r1 = new BinaryTreeNode<>(200);
        r1.setLeft(new BinaryTreeNode<>(125));
        r1.setRight(new BinaryTreeNode<>(350));
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(100, l1, r1);

        BTreePrinter.printNode(root);
        System.out.println("is bst rec1: " + isBst(root));
        System.out.println("is bst rec2: " + isBinarySearchTree(root));

        r1.setLeft(new BinaryTreeNode<>(90));
        BTreePrinter.printNode(root);
        System.out.println("is bst rec1: " + isBst(root));
        System.out.println("is bst rec2: " + isBinarySearchTree(root));
    }

    private static boolean isBstRec(BinaryTreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }
        if ((Integer) root.data < minValue || (Integer) root.data > maxValue) {
            return false;
        }
        return isBstRec(root.left, minValue, (Integer) root.data)
                && isBstRec(root.right, (Integer) root.data, maxValue);
    }

    private static boolean isBst(BinaryTreeNode root) {
        return isBstRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBinarySearchTree(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isBinarySearchTree(root.left)) {
            return false;
        }
        if (prev != null && (Integer) prev.data >= (Integer) root.data) {
            return false;
        }
        prev = root;

        if (!isBinarySearchTree(root.right)) {
            return false;
        }
        return true;
    }

}
