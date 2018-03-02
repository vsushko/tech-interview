package trees;

import common.BinaryTreeNode;

import java.util.ArrayDeque;

/**
 * Given the root to a binary tree where each node has an additional pointer called
 * sibling (or next), connect the sibling pointer to next node in the same level.
 * Last node in each level should point to the first node of next level in the tree.
 * <p>
 * Solution #1
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: Constant O(1).
 * <p>
 * Solution #2
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: Linear, O(n).
 */
public class ConnectAllSiblings {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> l1 = new BinaryTreeNode<>(50);
        l1.setLeft(new BinaryTreeNode<>(25));
        l1.setRight(new BinaryTreeNode<>(75));
        BinaryTreeNode<Integer> r1 = new BinaryTreeNode<>(200);
        BinaryTreeNode<Integer> rr1 = new BinaryTreeNode<>(300);
        rr1.setRight(new BinaryTreeNode<>(350));
        r1.setRight(rr1);
        BinaryTreeNode<Integer> root1 = new BinaryTreeNode<>(100, l1, r1);
        populateSiblingPointers(root1);

        BinaryTreeNode<Integer> root2 = new BinaryTreeNode<>(100, l1, r1);
        populateSiblingPointers2(root2);
    }

    private static void populateSiblingPointers(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        BinaryTreeNode current = root;
        BinaryTreeNode last = root;

        while (current != null) {
            if (current.left != null) {
                last.next = current.left;
                last = current.left;
            }
            if (current.right != null) {
                last.next = current.right;
                last = current.right;
            }
            last.next = null;
            current = current.next;
        }
    }

    private static void populateSiblingPointers2(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        BinaryTreeNode prev = null;

        while (!queue.isEmpty()) {
            BinaryTreeNode temp = queue.removeFirst();
            if (prev != null) {
                prev.next = temp;
            }
            prev = temp;
            if (temp.left != null) {
                queue.addLast(temp.left);
            }
            if (temp.right != null) {
                queue.addLast(temp.right);
            }
        }
        prev.next = null;
    }
}
