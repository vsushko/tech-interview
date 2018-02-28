package trees;

import common.BinaryTreeNode;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Serialize binary tree to a file and then deserialize back to tree
 * such that original and deserialized trees are identical.
 * <p>
 * Solution #1
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: Logarithmic, O(logn).
 * <p>
 * Solution #2
 * Runtime Complexity: Linearithmic, O(nlogn) in case of a balanced tree.
 * Quadratic, O(n2) in the worst case.
 * Memory Complexity: Logarithmic, O(logn).
 * <p>
 * Recursive solution has O(h) memory complexity as it will consume memory on the stack
 * up to the height of binary tree h. It will be O(logn) for balanced tree
 * and in worst case can be O(n).
 */
public class SerializeAndDeserializeBinaryTree {

    private static final int MARKER = Integer.MIN_VALUE;

    public static void main(String[] args) {
        BinaryTreeNode<Integer> l1 = new BinaryTreeNode<>(50);
        l1.setLeft(new BinaryTreeNode<>(25));
        l1.setRight(new BinaryTreeNode<>(75));
        BinaryTreeNode<Integer> r1 = new BinaryTreeNode<>(200);
        r1.setRight(new BinaryTreeNode<>(350));
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(100, l1, r1);

        try {
            ObjectOutputStream stream =
                    new ObjectOutputStream(new FileOutputStream("object.data"));
            serialize(root, stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream stream =
                    new ObjectInputStream(new FileInputStream("object.data"));
            deserialize(stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void serialize(BinaryTreeNode<Integer> node, ObjectOutputStream stream)
            throws IOException {
        if (node == null) {
            stream.writeInt(MARKER);
            return;
        }
        stream.writeInt(node.data);
        serialize(node.left, stream);
        serialize(node.right, stream);
    }

    private static BinaryTreeNode<Integer> deserialize(ObjectInputStream stream)
            throws IOException {
        int val = stream.readInt();
        if (val == MARKER) {
            return null;
        }
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(val);
        node.left = deserialize(stream);
        node.right = deserialize(stream);
        return node;
    }

    private static void serializePerorder(BinaryTreeNode<Integer> node, ObjectOutputStream stream) throws IOException {
        if (node == null) {
            return;
        }

        stream.writeInt(node.data);
        serializePerorder(node.left, stream);
        serializePerorder(node.right, stream);
    }

    private static void serializeInOrder(BinaryTreeNode<Integer> node, ObjectOutputStream stream)
            throws IOException {
        if (node == null) {
            return;
        }

        serializeInOrder(node.left, stream);
        stream.writeInt(node.data);
        serializeInOrder(node.right, stream);
    }

    public static List<Integer> deserializePreorder(ObjectInputStream stream, int size)
            throws IOException {
        List<Integer> v = new ArrayList<>();
        int i = 0;

        while (i < size) {
            v.add(stream.readInt());
            i++;
        }
        return v;
    }

    public static List<Integer> deserializeInorder(ObjectInputStream stream, int size)
            throws IOException {
        List<Integer> v = new ArrayList<>();
        int i = 0;

        while (i < size) {
            v.add(stream.readInt());
            i++;
        }
        return v;
    }

    private static BinaryTreeNode deserialize2(List preOrder, List inOrder, int preStart,
                                               int inStart, int preEnd, int inEnd) {
        // check if there is no element or one element
        if (preStart > preEnd) {
            return null;
        } else if (preStart == preEnd) {
            BinaryTreeNode node = new BinaryTreeNode<>((int) preOrder.get(preStart));
            node.left = null;
            node.right = null;
            return node;
        }
        // otherwise first element in preOrder array is root, we find that value in
        // inOrder array and determine how many elements are in left and right subtrees
        int rootIndexInorder = 0;

        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder.get(i).equals(preOrder.get(preStart))) {
                // we find the first value of preOrder in inOrder array
                rootIndexInorder = i;
                break;
            }
        }
        // now we calculate number of elements in right subtree and left subtree
        int leftSubCount = rootIndexInorder - inStart;
        int rightSubCount = inEnd - rootIndexInorder;

        BinaryTreeNode node = new BinaryTreeNode((int) preOrder.get(preStart));
        node.left = deserialize2(preOrder, inOrder, preStart + 1,
                inStart, preStart + leftSubCount, inStart + leftSubCount - 1);
        node.right = deserialize2(preOrder, inOrder, preStart + leftSubCount + 1,
                inStart + leftSubCount + 1, preEnd, inEnd);
        return node;
    }

}
