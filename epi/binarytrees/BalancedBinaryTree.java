package binarytrees;

import common.BinaryTreeNode;

public class BalancedBinaryTree {
    public static boolean isBalanced(BinaryTreeNode<Integer> tree) {
        return checkBalanced(tree).balanced;
    }

    private static BalanceStatusWithHeight checkBalanced(
            BinaryTreeNode<Integer> tree) {
        if (tree == null) {
            return new BalanceStatusWithHeight(true, -1); // Base case.
        }

        BalanceStatusWithHeight leftResult = checkBalanced(tree.left);
        if (!leftResult.balanced) {
            return leftResult; // Left subtree is not balanced.
        }
        BalanceStatusWithHeight rightResult = checkBalanced(tree.right);
        if (!rightResult.balanced) {
            return rightResult; // Right subtree is not balanced.
        }

        boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
        int height = Math.max(leftResult.height, rightResult.height) + 1;
        return new BalanceStatusWithHeight(isBalanced, height);
    }

    public static void main(String[] args) {
        // balanced binary tree test
        // 3
        // 2 5
        // 1 4 6
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<>();
        tree.left = new BinaryTreeNode<>();
        tree.left.left = new BinaryTreeNode<>();
        tree.right = new BinaryTreeNode<>();
        tree.right.left = new BinaryTreeNode<>();
        tree.right.right = new BinaryTreeNode<>();
        if (!isBalanced(tree)) {
            System.err.println("Incorrect result on balanced tree " + tree);
            System.exit(-1);
        }
        tree = new BinaryTreeNode<>();
        tree.left = new BinaryTreeNode<>();
        tree.left.left = new BinaryTreeNode<>();
        if (isBalanced(tree)) {
            System.err.println("Incorrect result on unbalanced tree: " + tree);
            System.exit(-1);
        }
    }
    // @exclude

    // @include
    private static class BalanceStatusWithHeight {
        public boolean balanced;
        public int height;

        public BalanceStatusWithHeight(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }
}
