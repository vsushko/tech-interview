package trees;

import common.BinaryTreeNode;

/**
 * Given roots of two binary trees, determine if these trees are identical or not.
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: O(h).
 * The recursive solution has O(h) memory complexity as it will consume memory
 * on the stack up to the height of binary tree h. It will be O(log n)
 * for a balanced tree and in the worst case can be O(n).
 */
public class CheckIfTwoBinaryTreesAreIdentical {

    public static void main(String[] args) {

        BinaryTreeNode<Integer> left1 = new BinaryTreeNode<>(50);
        left1.setLeft(new BinaryTreeNode<>(25));
        BinaryTreeNode<Integer> right1 = new BinaryTreeNode<>(200);
        right1.setLeft(new BinaryTreeNode<>(125));
        right1.setRight(new BinaryTreeNode<>(350));
        BinaryTreeNode<Integer> root1 = new BinaryTreeNode<>(100, left1, right1);

        BinaryTreeNode<Integer> left2 = new BinaryTreeNode<>(50);
        left2.setLeft(new BinaryTreeNode<>(25));
        BinaryTreeNode<Integer> right2 = new BinaryTreeNode<>(200);
        right2.setLeft(new BinaryTreeNode<>(125));
        right2.setRight(new BinaryTreeNode<>(350));
        BinaryTreeNode<Integer> root2 = new BinaryTreeNode<>(100, left2, right2);

        System.out.println(areIdentical(root1, root2));
    }

    private static boolean areIdentical(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 != null && root2 != null) {
            return (root1.data.equals(root2.data))
                    && areIdentical(root1.left, root2.left)
                    && areIdentical(root1.right, root2.right);
        }
        return false;
    }

}
