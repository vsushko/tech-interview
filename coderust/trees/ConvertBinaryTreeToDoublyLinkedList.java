package trees;

import common.BinaryTreeNode;
import utilities.BTreePrinter;

/**
 * Given a binary tree, convert it to a doubly linked list such that
 * the order of doubly linked list is the same as in-order traversal
 * of the binary tree.
 * <p>
 * Runtime Complexity: Linear, O(n).
 * Runtime complexity is based on the number of nodes in the tree.
 * <p>
 * Memory Complexity: Linear, O(h).
 * Recursive solution has O(h) memory complexity as it will consume memory on the stack
 * up to the height of binary tree 'h'. It will be O(log n) for balanced tree and in worst case can be O(n).
 */
public class ConvertBinaryTreeToDoublyLinkedList {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> l1 = new BinaryTreeNode<>(50);
        BinaryTreeNode<Integer> ll3 = new BinaryTreeNode<>(25);
        ll3.setRight(new BinaryTreeNode<>(30));
        l1.setLeft(ll3);
        BinaryTreeNode<Integer> lr3 = new BinaryTreeNode<>(75);
        lr3.setLeft(new BinaryTreeNode<>(60));
        l1.setRight(lr3);
        BinaryTreeNode<Integer> r1 = new BinaryTreeNode<>(200);
        r1.setLeft(new BinaryTreeNode<>(125));
        r1.setRight(new BinaryTreeNode<>(350));
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(100, l1, r1);

        BTreePrinter.printNode(root);

        BinaryTreeNode convertedBinaryTree = convertToLinkedList(root);
    }

    // merge(fuse) two sorted linked lists
    private static BinaryTreeNode concatenateLists(BinaryTreeNode head1,
                                                   BinaryTreeNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        BinaryTreeNode tail1 = head1.left;
        BinaryTreeNode tail2 = head2.left;

        tail1.right = head2;
        head2.left = tail1;

        head1.left = tail2;
        tail2.right = head1;

        return head1;
    }

    private static BinaryTreeNode convertToLinkedList(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode list1 = convertToLinkedList(root.left);
        BinaryTreeNode list2 = convertToLinkedList(root.right);

        root.left = root.right = root;
        BinaryTreeNode result = concatenateLists(list1, root);
        result = concatenateLists(result, list2);

        return result;
    }

}
