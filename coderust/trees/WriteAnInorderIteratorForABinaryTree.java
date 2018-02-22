package trees;

import common.BinaryTreeNode;

import java.util.Stack;

/**
 * Implement a class that implements an InOrder Iterator on a Binary Tree
 * <p>
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: O(h).
 * <p>
 * Iterative solution has O(h) memory complexity as it instantiates a stack
 * that has to store information up to height of binary tree h.
 * It will be O(logn) for balanced tree and in worst case, can be O(n).
 */
public class WriteAnInorderIteratorForABinaryTree {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> l1 = new BinaryTreeNode<>(50);
        l1.setLeft(new BinaryTreeNode<>(25));
        BinaryTreeNode<Integer> r1 = new BinaryTreeNode<>(200);
        r1.setLeft(new BinaryTreeNode<>(125));
        r1.setRight(new BinaryTreeNode<>(350));
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(100, l1, r1);

        InOrderTreeIterator iterator = new InOrderTreeIterator(root);
        while (iterator.hasNext()) {
            System.out.print(iterator.getNext().data + "->");
        }
    }
}

class InOrderTreeIterator {

    private Stack<BinaryTreeNode> stack = new Stack<>();

    InOrderTreeIterator(BinaryTreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public BinaryTreeNode getNext() {
        if (stack.isEmpty()) {
            return null;
        }

        BinaryTreeNode rVal = stack.pop();
        BinaryTreeNode temp = rVal.right;

        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        return rVal;
    }
}






















