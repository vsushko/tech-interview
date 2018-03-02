package trees;

import common.BinaryTreeNode;

/**
 * Find nth highest node in a Binary Search Tree(BST).
 * <p>
 * Solution #1
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: O(h)
 * <p>
 * The recursive solution has O(h) memory complexity as it will consume memory
 * on the stack up to the height of the binary search tree h.
 * It will be O(logn) for a balanced tree and in worst can be O(n).
 * <p>
 * Solution #2
 * Runtime Complexity: Linear, O(n).
 * It will be O(logn) for a balanced tree and in worst can be O(n).
 * Memory Complexity: Linear, O(h)
 */
public class NthHighestInBST {

    private static int currentCount = 0;

    public static void main(String[] args) {
        BinaryTreeNode<Integer> l1 = new BinaryTreeNode<>(50);
        l1.count = 3;
        BinaryTreeNode<Integer> left = new BinaryTreeNode<>(25);
        left.count = 1;
        l1.setLeft(left);
        BinaryTreeNode<Integer> right = new BinaryTreeNode<>(75);
        right.count = 1;
        l1.setRight(right);
        BinaryTreeNode<Integer> r1 = new BinaryTreeNode<>(200);
        r1.count = 3;
        BinaryTreeNode<Integer> left1 = new BinaryTreeNode<>(125);
        left1.count = 1;
        r1.setLeft(left1);
        BinaryTreeNode<Integer> right1 = new BinaryTreeNode<>(350);
        right.count = 1;
        r1.setRight(right1);
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(100, l1, r1);
        root.count = 7;

        BinaryTreeNode nthHighestInBST = findNthHighestInBST(root, 3);
        System.out.println(nthHighestInBST.data);
        BinaryTreeNode nthHighestInBstWithCounts = findNthHighestInBstWithCounts(root, 5);
        System.out.println(nthHighestInBstWithCounts.data);
    }

    private static BinaryTreeNode findNthHighestInBST(BinaryTreeNode node, int n) {
        if (node == null) {
            return null;
        }
        BinaryTreeNode result = findNthHighestInBST(node.right, n);

        if (result != null) {
            return result;
        }
        currentCount++;
        if (n == currentCount) {
            return node;
        }
        result = findNthHighestInBST(node.left, n);

        if (result != null) {
            return result;
        }
        return null;
    }

    private static BinaryTreeNode findNthHighestInBstWithCounts(BinaryTreeNode node, int n) {
        if (node == null) {
            return null;
        }

        int leftCount = 0;

        if (node.left != null) {
            leftCount = node.left.count;
        }
        int k = node.count - leftCount;

        if (k == n) {
            return node;
        } else if (k > n) {
            return findNthHighestInBstWithCounts(node.right, n);
        } else {
            return findNthHighestInBstWithCounts(node.left, n - k);
        }
    }
}
