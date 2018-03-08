package graphs;

import java.util.*;

/**
 * Given root node of a directed graph, clone this graph by creating its deep
 * copy such that cloned graph has same vertices and edges as original graph.
 * <p>
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: Logarithmic, O(n). 'n' is number of vertices in graph.
 * We can have most n entries in hash table, so worst case space complexity is O(n).
 */
public class CloneADirectedGraph {

    public static void main(String[] args) {

        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node0.neighbors.addAll(Arrays.asList(node4, node3, node2));
        node1.neighbors.addAll(Collections.singletonList(node2));
        node1.neighbors.addAll(Collections.singletonList(node0));
        node3.neighbors.addAll(Collections.singletonList(node2));
        node4.neighbors.addAll(Arrays.asList(node3, node1, node0));

        Node clone = DirectedGraph.clone(node0);
        System.out.println(clone);
    }
}

class Node {
    public int data;
    public List<Node> neighbors = new ArrayList<>();

    public Node(int d) {
        data = d;
    }
}

class DirectedGraph {
    private static Node cloneRec(Node root, Map<Node, Node> nodesCompleted) {
        if (root == null) {
            return null;
        }
        Node pNew = new Node(root.data);
        nodesCompleted.put(root, pNew);

        for (Node p : root.neighbors) {
            Node x = nodesCompleted.get(p);
            if (x == null) {
                pNew.neighbors.add(cloneRec(p, nodesCompleted));
            } else {
                pNew.neighbors.add(x);
            }
        }
        return pNew;
    }

    public static Node clone(Node root) {
        Map<Node, Node> nodesCompleted = new HashMap<>();
        return cloneRec(root, nodesCompleted);
    }
}