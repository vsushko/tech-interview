package trees;

import common.BinaryTreeNode;
import utilities.BTreePrinter;

/**
 * Given a binary tree, connect its siblings at each level.
 * <p>
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: Constant O(1).
 */
public class ConnectSameLevelSiblings {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> l1 = new BinaryTreeNode<>(50);
        BinaryTreeNode<Integer> ll3 = new BinaryTreeNode<>(25);
        BinaryTreeNode<Integer> ll3r = new BinaryTreeNode<>(10);
        ll3r.setRight(new BinaryTreeNode<>(15));
        ll3.setLeft(ll3r);
        l1.setLeft(ll3);
        l1.setRight(new BinaryTreeNode<>(75));
        BinaryTreeNode<Integer> r1 = new BinaryTreeNode<>(200);
        BinaryTreeNode<Integer> r12 = new BinaryTreeNode<>(300);
        r12.setRight(new BinaryTreeNode<>(350));
        r1.setRight(r12);
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(100, l1, r1);

        BTreePrinter.printNode(root);

        populateSiblingPointers(root);

        InOrderTreeIterator iterator = new InOrderTreeIterator(root);
        while (iterator.hasNext()) {
            BinaryTreeNode node = iterator.getNext();
            System.out.print(node.data + "->" + (node.next == null ? "NULL" : node.next.data) + " ");
        }

    }

    private static BinaryTreeNode connectNextLevel(BinaryTreeNode head) {
        BinaryTreeNode current = head;
        BinaryTreeNode nextLevelHead = null;
        BinaryTreeNode prev = null;

        while (current != null) {
            if (current.left != null && current.right != null) {
                if (nextLevelHead == null) {
                    nextLevelHead = current.left;
                }

                current.left.next = current.right;

                if (prev != null) {
                    prev.next = current.left;
                }
                prev = current.right;
            } else if (current.left != null) {
                if (nextLevelHead == null) {
                    nextLevelHead = current.left;
                }

                if (prev != null) {
                    prev.next = current.left;
                }
                prev = current.left;
            } else if (current.right != null) {
                if (nextLevelHead == null) {
                    nextLevelHead = current.right;
                }
                if (prev != null) {
                    prev.next = current.right;
                }
                prev = current.right;
            }
            current = current.next;
        }
        if (prev != null) {
            prev.next = null;
        }
        return nextLevelHead;
    }

    private static void populateSiblingPointers(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        root.next = null;

        do {
            root = connectNextLevel(root);
        } while (root != null);
    }
}
