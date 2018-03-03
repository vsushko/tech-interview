package trees;

import common.BinaryTreeNode;
import utilities.BTreePrinter;
import utilities.TreeNode;

import java.util.Arrays;

/**
 * Convert an N-ary tree to Binary tree and then convert this Binary tree
 * back to its original N-ary tree structure.
 * <p>
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: O(h).
 * <p>
 * Recursive solution has O(h) memory complexity as it will consume memory
 * on the stack up to the height of binary tree h.
 * It will be O(logn) for balanced tree and in worst case can be O(n).
 */
public class NaryTreeToBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode("1");
        TreeNode child2 = new TreeNode("2");
        TreeNode child3 = new TreeNode("3");
        child3.getChildren().add(new TreeNode("8"));
        TreeNode child4 = new TreeNode("4");
        TreeNode child9 = new TreeNode("9");
        child9.getChildren().add(new TreeNode("13"));
        child4.getChildren().addAll(Arrays.asList(child9, new TreeNode("10")));
        TreeNode child6 = new TreeNode("6");
        child6.getChildren().addAll(Arrays.asList(new TreeNode("11"), new TreeNode("12")));
        child2.getChildren().addAll(Arrays.asList(new TreeNode("5"), child6, new TreeNode("7")));
        root.getChildren().addAll(Arrays.asList(child2, child3, child4));

        BinaryTreeNode binaryTreeNode = convertNAryToBinary(root);
        BTreePrinter.printNode(binaryTreeNode);
    }

    private static BinaryTreeNode convertNAryToBinary(TreeNode root) {
        return convertNAryToBinaryRec(root, true);
    }

    private static BinaryTreeNode convertNAryToBinaryRec(TreeNode node,
                                                         boolean isLeft) {
        if (node == null) {
            return null;
        }

        BinaryTreeNode btNode = new BinaryTreeNode(node.getData());
        BinaryTreeNode lastNode = btNode;

        for (int i = 0; i < node.getChildren().size(); i++) {
            if (isLeft) {
                lastNode.left =
                        convertNAryToBinaryRec(node.getChildren().get(i), !isLeft);
                lastNode = lastNode.left;
            } else {
                lastNode.right = convertNAryToBinaryRec(node.getChildren().get(i), !isLeft);
                lastNode = lastNode.right;
            }
        }
        return btNode;
    }

    public static TreeNode convertBinaryToNAryTree(BinaryTreeNode root) {
        return convertBinaryToNAryTreeRec(root, true);
    }

    private static TreeNode convertBinaryToNAryTreeRec(BinaryTreeNode node, boolean isLeft) {
        if (node == null) {
            return null;
        }
        TreeNode nNode = new TreeNode(node.data.toString());
        BinaryTreeNode temp = node;

        if (isLeft) {
            while (temp.left != null) {
                TreeNode child = convertBinaryToNAryTreeRec(temp.left, !isLeft);
                nNode.getChildren().add(child);
                temp = temp.left;
            }
        } else {
            while (temp.right != null) {
                TreeNode child = convertBinaryToNAryTreeRec(temp.right, !isLeft);
                nNode.getChildren().add(child);
                temp = temp.right;
            }
        }
        return nNode;
    }
}
