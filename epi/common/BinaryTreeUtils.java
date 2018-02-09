package common;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author translated from c++ by Blazheev Alexander
 */
public class BinaryTreeUtils {
    public static BinaryTreeNode<Integer> generateRandBinaryTree(int n,
                                                                 boolean isUnique) {
        Random r = new Random();
        ArrayList<BinaryTreeNode<Integer>> l = new ArrayList<BinaryTreeNode<Integer>>();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(isUnique ? n--
                : r.nextInt(Integer.MAX_VALUE));
        l.add(root);
        while (n-- > 0) {
            int x = r.nextInt(l.size());
            boolean addLeft = r.nextBoolean();
            BinaryTreeNode<Integer> it = l.get(x);
            if (addLeft && it.getLeft() == null || !addLeft && it.getRight() == null) {
                it.setLeft(new BinaryTreeNode<Integer>(isUnique ? n : r
                        .nextInt(Integer.MAX_VALUE)));
                l.add(it.getLeft());
            } else {
                it.setRight(new BinaryTreeNode<Integer>(isUnique ? n : r
                        .nextInt(Integer.MAX_VALUE)));
                l.add(it.getRight());
            }
            if (it.getLeft() != null && it.getRight() != null) {
                l.remove(x);
            }
        }
        return root;
    }

    private static <T> void generatePreOrderHelper(BinaryTreeNode<T> r,
                                                   ArrayList<T> ret) {
        if (r != null) {
            ret.add(r.getData());
            generatePreOrderHelper(r.getLeft(), ret);
            generatePreOrderHelper(r.getRight(), ret);
        }
    }

    public static <T> ArrayList<T> generatePreOrder(BinaryTreeNode<T> r) {
        ArrayList<T> ret = new ArrayList<T>();
        generatePreOrderHelper(r, ret);
        return ret;
    }

    private static <T> void generateInOrderHelper(BinaryTreeNode<T> r,
                                                  ArrayList<T> ret) {
        if (r != null) {
            generateInOrderHelper(r.getLeft(), ret);
            ret.add(r.getData());
            generateInOrderHelper(r.getRight(), ret);
        }
    }

    public static <T> ArrayList<T> generateInOrder(BinaryTreeNode<T> r) {
        ArrayList<T> ret = new ArrayList<T>();
        generateInOrderHelper(r, ret);
        return ret;
    }

    private static <T> void generatePostOrderHelper(BinaryTreeNode<T> r,
                                                    ArrayList<T> ret) {
        if (r != null) {
            generatePostOrderHelper(r.getLeft(), ret);
            generatePostOrderHelper(r.getRight(), ret);
            ret.add(r.getData());
        }
    }

    public static <T> ArrayList<T> generatePostOrder(BinaryTreeNode<T> r) {
        ArrayList<T> ret = new ArrayList<T>();
        generatePostOrderHelper(r, ret);
        return ret;
    }

}
