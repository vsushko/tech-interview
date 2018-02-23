package trees;

import common.BinaryTreeNode;

/**
 * Inorder successor of a node in binary Search Tree (BST) is the next node
 * in inorder traversal. Write a method to find the inorder successor of
 * a given value "d" in a BST.
 * <p>
 * Runtime Complexity: Logarithmic, O(logn).
 * Memory Complexity: Constant, O(1).
 */
public class InorderSuccessorBST {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> l1 = new BinaryTreeNode<>(50);
        l1.setLeft(new BinaryTreeNode<>(25));
        l1.setRight(new BinaryTreeNode<>(75));
        BinaryTreeNode<Integer> r1 = new BinaryTreeNode<>(200);
        r1.setLeft(new BinaryTreeNode<>(125));
        r1.setRight(new BinaryTreeNode<>(350));
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(100, l1, r1);

        BinaryTreeNode binaryTreeNode = inorderSuccessorBst(root, 25);
        System.out.println("Inorder successor of 25 is " + binaryTreeNode.data);
        binaryTreeNode = inorderSuccessorBst(root, 50);
        System.out.println("Inorder successor of 50 is " + binaryTreeNode.data);
        binaryTreeNode = inorderSuccessorBst(root, 75);
        System.out.println("Inorder successor of 75 is " + binaryTreeNode.data);
        binaryTreeNode = inorderSuccessorBst(root, 100);
        System.out.println("Inorder successor of 100 is " + binaryTreeNode.data);
        binaryTreeNode = inorderSuccessorBst(root, 125);
        System.out.println("Inorder successor of 125 is " + binaryTreeNode.data);
        binaryTreeNode = inorderSuccessorBst(root, 200);
        System.out.println("Inorder successor of 200 is " + binaryTreeNode.data);
        binaryTreeNode = inorderSuccessorBst(root, 350);
        System.out.println("Inorder successor of 350 is " + (binaryTreeNode == null ? "NULL" : ""));
    }

    private static BinaryTreeNode findMin(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private static BinaryTreeNode inorderSuccessorBst(BinaryTreeNode root, int d) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode successor = null;
        while (root != null) {
            if ((Integer) root.data < d) {
                root = root.right;
            } else if ((Integer) root.data > d) {
                successor = root;
                root = root.left;
            } else {
                if (root.right != null) {
                    successor = findMin(root.right);
                }
                break;
            }
        }
        return successor;
    }

}
