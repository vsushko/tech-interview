package trees;

import common.BinaryTreeNode;
import utilities.BTreePrinter;

/**
 * Given root of a binary tree, delete any subtrees whose nodes sum up to zero.
 * <p>
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: O(h).
 * <p>
 * Recursive solution has O(h) memory complexity as it will consume memory
 * on the stack up to height of binary tree h. It will be O(logn)
 * for balanced tree and in worst case can be O(n).
 */
public class DeleteZeroSumSubTrees {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> l1 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> left = new BinaryTreeNode<>(-3);
        l1.setLeft(left);
        BinaryTreeNode<Integer> right = new BinaryTreeNode<>(-2);
        l1.setRight(right);
        BinaryTreeNode<Integer> r1 = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(7, l1, r1);
        //l1.root = root;
        //r1.root = root;
        //left.root = l1;
        //right.root = l1;

        BTreePrinter.printNode(root);
        deleteZeroSumSubTreeRec(root);
        BTreePrinter.printNode(root);
    }

    private static int deleteZeroSumSubTreeRec(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int sumLeft = deleteZeroSumSubTreeRec(root.left);
        int sumRight = deleteZeroSumSubTreeRec(root.right);

        if (sumLeft == 0) {
            root.left = null;
        }
        if (sumRight == 0) {
            root.right = null;
        }
        return (int) root.data + sumLeft + sumRight;
    }

    private static void deleteZeroSumSubtree(BinaryTreeNode tree) {
        if (tree == null || tree.root == null) {
            return;
        }
        if (deleteZeroSumSubTreeRec(tree.root) == 0) {
            tree.root = null;
        }
    }
}
