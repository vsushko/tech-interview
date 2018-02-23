package trees;

import common.BinaryTreeNode;

import java.util.Stack;

/**
 * Write inorder traversal of a binary tree iteratively.
 * <p>
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: O(h).
 * <p>
 * The iterative solution has O(h) memory complexity as it instantiates a stack
 * that has to store information up to the height of binary tree h.
 * It will be O(log n) for a balanced tree and can be O(n) in the worst case.
 */
public class IterativeInorderTraversal {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> l1 = new BinaryTreeNode<>(50);
        l1.setLeft(new BinaryTreeNode<>(25));
        BinaryTreeNode<Integer> r1 = new BinaryTreeNode<>(200);
        r1.setLeft(new BinaryTreeNode<>(125));
        r1.setRight(new BinaryTreeNode<>(350));
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(100, l1, r1);

        inorderIterative(root);
    }

    private static void inorderIterative(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();

        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
                continue;
            }
            System.out.print(stack.peek().data + " ");
            root = stack.pop().right;
        }
    }
}
