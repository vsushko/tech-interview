package utilities;

import common.LinkedListNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class CodeRustUtils {

    private CodeRustUtils() {
        super();
    }

    public static String toStringTree(TreeNode node) {
        final StringBuilder buffer = new StringBuilder();
        return toStringTreeHelper(node, buffer, new LinkedList<>()).toString();
    }

    private static String toStringTreeDrawLines(List<Iterator<TreeNode>> parentIterators, boolean amLast) {
        StringBuilder result = new StringBuilder();
        Iterator<Iterator<TreeNode>> it = parentIterators.iterator();
        while (it.hasNext()) {
            Iterator<TreeNode> anIt = it.next();
            if (anIt.hasNext() || (!it.hasNext() && amLast)) {
                result.append("   |");
            } else {
                result.append("    ");
            }
        }
        return result.toString();
    }

    private static StringBuilder toStringTreeHelper(TreeNode node, StringBuilder buffer, List<Iterator<TreeNode>>
            parentIterators) {
        if (!parentIterators.isEmpty()) {
            boolean amLast = !parentIterators.get(parentIterators.size() - 1).hasNext();
            buffer.append("\n");
            String lines = toStringTreeDrawLines(parentIterators, amLast);
            buffer.append(lines);
            buffer.append("\n");
            buffer.append(lines);
            buffer.append("- ");
        }
        buffer.append(node.getData());
        if (node.hasChildren()) {
            Iterator<TreeNode> it = node.getChildren().iterator();
            parentIterators.add(it);
            while (it.hasNext()) {
                TreeNode child = it.next();
                toStringTreeHelper(child, buffer, parentIterators);
            }
            parentIterators.remove(it);
        }
        return buffer;
    }

    public static void printLinkedList(LinkedListNode reversed) {
        StringBuilder stringBuilder = new StringBuilder();
        LinkedListNode current = reversed;
        while (current != null) {
            stringBuilder.append(current.data);
            if (current.next != null) {
                stringBuilder.append("->");
            }
            current = current.next;
        }
        System.out.println(stringBuilder.toString());
    }
}
