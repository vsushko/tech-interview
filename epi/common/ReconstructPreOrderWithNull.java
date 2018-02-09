package common;

import java.util.List;

public class ReconstructPreOrderWithNull {
    private static Integer idx;

    public static BinaryTreeNode reconstructPreOrder(List<Integer> preorder) {
        idx = 0;
        return reconstructPreOrderHelper(preorder);
    }

    private static BinaryTreeNode reconstructPreOrderHelper(List<Integer> preorder) {
        Integer rootVal = preorder.get(idx++);
        if (rootVal == null) {
            return null;
        }
        BinaryTreeNode left = reconstructPreOrder(preorder);
        BinaryTreeNode right = reconstructPreOrder(preorder);
        return new BinaryTreeNode(rootVal, left, right);
    }
}