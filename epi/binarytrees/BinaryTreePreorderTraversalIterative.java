package binarytrees;

import common.BinaryTreeNode;
import common.BinaryTreeUtils;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversalIterative {
    // @include
    public static List<Integer> preorderTraversal(BinaryTreeNode<Integer> tree) {
        Deque<BinaryTreeNode<Integer>> path = new LinkedList<>();
        path.addFirst(tree);
        List<Integer> result = new ArrayList<>();
        while (!path.isEmpty()) {
            BinaryTreeNode<Integer> curr = path.removeFirst();
            if (curr != null) {
                result.add(curr.data);
                path.addFirst(curr.right);
                path.addFirst(curr.left);
            }
        }
        return result;
    }
    // @exclude

    public static void main(String[] args) {
        // 3
        // 2 5
        // 1 4 6
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<>(3);
        tree.left = new BinaryTreeNode<>(2);
        tree.left.left = new BinaryTreeNode<>(1);
        tree.right = new BinaryTreeNode<>(5);
        tree.right.left = new BinaryTreeNode<>(4);
        tree.right.right = new BinaryTreeNode<>(6);
        List<Integer> res = preorderTraversal(tree);
        List<Integer> goldenRes = BinaryTreeUtils.generatePreOrder(tree);
        assert (res.equals(goldenRes));
    }
}
