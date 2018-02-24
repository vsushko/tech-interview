package trees;

import common.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Given root of a binary tree, display node values at each level.
 * Node values for all levels should be displayed on separate lines.
 * <p>
 * Solution #1
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: Linear, O(n).
 * <p>
 * Iterative solution has O(n) memory complexity as it instantiates queues
 * that can take space up to n/2 nodes.
 * <p>
 * Solution #2
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: Linear, O(n).
 * Iterative solution has O(n) memory complexity as it instantiates queues
 * that can take space upto n/2 nodes.
 */
public class LevelOrderTraversal {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> l1 = new BinaryTreeNode<>(50);
        l1.setLeft(new BinaryTreeNode<>(25));
        l1.setRight(new BinaryTreeNode<>(75));
        BinaryTreeNode<Integer> r1 = new BinaryTreeNode<>(200);
        r1.setRight(new BinaryTreeNode<>(350));
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(100, l1, r1);

        levelOrderTraversal1(root);
        levelOrderTraversal2(root);
    }

    private static void levelOrderTraversal1(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        List<Queue<BinaryTreeNode>> queues = new ArrayList<>();
        queues.add(new ArrayDeque<>());
        queues.add(new ArrayDeque<>());

        Queue<BinaryTreeNode> currentQueue = queues.get(0);
        Queue<BinaryTreeNode> nextQueue = queues.get(1);

        currentQueue.add(root);
        int levelNumber = 0;

        while (!currentQueue.isEmpty()) {
            BinaryTreeNode temp = currentQueue.poll();
            System.out.print(temp.data + ",");

            if (temp.left != null) {
                nextQueue.add(temp.left);
            }
            if (temp.right != null) {
                nextQueue.add(temp.right);
            }
            if (currentQueue.isEmpty()) {
                System.out.println();
                ++levelNumber;
                currentQueue = queues.get(levelNumber % 2);
                nextQueue = queues.get((levelNumber + 1) % 2);
            }
        }
        System.out.println();
    }

    // using one queue
    private static void levelOrderTraversal2(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> currentQueue = new ArrayDeque<>();

        BinaryTreeNode dummyNode = new BinaryTreeNode(0);

        currentQueue.add(root);
        currentQueue.add(dummyNode);

        while (!currentQueue.isEmpty()) {
            BinaryTreeNode temp = currentQueue.poll();
            System.out.print(temp.data + ",");

            if (temp.left != null) {
                currentQueue.add(temp.left);
            }
            if (temp.right != null) {
                currentQueue.add(temp.right);
            }
            if (currentQueue.peek() == dummyNode) {
                System.out.println();

                currentQueue.remove();

                if (!currentQueue.isEmpty()) {
                    currentQueue.add(dummyNode);
                }
            }
        }
        System.out.println();
    }
}
