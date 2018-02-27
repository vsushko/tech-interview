package trees;

import common.BinaryTreeNode;

import java.util.Stack;

/**
 * Given the root node of a binary tree, print nodes forming the boundary (perimeter).
 * <p>
 * Runtime Complexity:  Linear, O(n).
 * Memory Complexity: O(h).
 * <p>
 * Recursive solution has O(h) memory complexity as it will consume memory
 * on the stack up to height of binary tree h. It will be O(logn)
 * for balanced tree and in worst case can be O(n).
 */
public class PrintTreePerimeter {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> l1 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> l2 = new BinaryTreeNode<>(4);
        l2.setLeft(new BinaryTreeNode<>(9));
        l1.setLeft(l2);
        BinaryTreeNode<Integer> l1r1 = new BinaryTreeNode<>(5);
        l1r1.setRight(new BinaryTreeNode<>(8));
        l1.setRight(l1r1);
        BinaryTreeNode<Integer> r1 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> r2 = new BinaryTreeNode<>(7);
        r2.setRight(new BinaryTreeNode<>(10));
        r1.setRight(r2);
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1, l1, r1);

        displayTreePerimeter(root);
    }

    private static void printLeftPerimeter(BinaryTreeNode root) {
        while (root != null) {
            int currVal = (int) root.data;

            if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                // leaf node
                break;
            }
            System.out.print(currVal + " ");
        }
    }

    private static void printRightPerimeter(BinaryTreeNode root) {
        // stack for right side values
        Stack<Integer> rValues = new Stack<>();

        while (root != null) {
            int currVal = (int) root.data;

            if (root.right != null) {
                root = root.right;
            } else if (root.left != null) {
                root = root.left;
            } else {
                // leaf node
                break;
            }
            rValues.push(currVal);
        }

        while (!rValues.isEmpty()) {
            System.out.print(rValues.pop() + " ");
        }
    }

    private static void printLeafNodes(BinaryTreeNode root) {
        if (root != null) {
            printLeafNodes(root.left);
            printLeafNodes(root.right);
            if (root.left == null && root.right == null) {
                System.out.print(root.data + " ");
            }
        }
    }

    private static void displayTreePerimeter(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");

            printLeftPerimeter(root.left);

            if (root.left != null || root.right != null) {
                // we don't need to print if root is also the leaf node
                printLeafNodes(root);
            }

            printRightPerimeter(root.right);
        }
    }
}
