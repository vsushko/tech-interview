package trees;

import common.BinaryTreeNode;
import utilities.BTreePrinter;

/**
 * Given the root node of a binary tree, swap the 'left' and 'right'
 * children for each node.
 * <p>
 * Runtime Complexity: Linear, O(n).
 * Every sub-tree needs to be mirrored so we visit every node once and mirror
 * the sub-tree starting there. Hence run time complexity is O(n).
 * <p>
 * Memory Complexity: Linear, O(n) in the worst case.
 * Recursive solution has O(h) memory complexity, for a balanced tree,
 * as it will consume memory on the stack up to the height of the binary tree.
 * For a skewed tree, it can be O(n).
 */
public class MirrorBinaryTreeNodes {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> l1 = new BinaryTreeNode<>(50);
        l1.setLeft(new BinaryTreeNode<>(25));
        l1.setRight(new BinaryTreeNode<>(75));
        BinaryTreeNode<Integer> r1 = new BinaryTreeNode<>(200);
        r1.setRight(new BinaryTreeNode<>(350));
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(100, l1, r1);

        BTreePrinter.printNode(root);
        mirrorBinaryTree(root);
        BTreePrinter.printNode(root);
    }

    private static void mirrorBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        // we will do a post-order traversal of the binary tree
        if (root.left != null) {
            mirrorBinaryTree(root.left);
        }
        if (root.right != null) {
            mirrorBinaryTree(root.right);
        }
        // let's swap the left and right nodes at current level
        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

}
