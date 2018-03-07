package graphs;

import java.util.Arrays;
import java.util.Collections;

/**
 * Find the minimum spanning tree of a connected, undirected graph with weighted edges.
 * <p>
 * Runtime Complexity: Quadratic, O(n2).
 * Here, 'n' is the number of vertices.
 * Memory Complexity: Linear, O(n + e).
 * Here, 'n' is the number of vertices and 'e' is the number of edges.
 */
public class MinimumSpanningTree {

    public static void main(String[] args) {
        Vertex v1 = new Vertex(0, "1");
        Vertex v2 = new Vertex(1, "2");
        Vertex v3 = new Vertex(2, "3");
        Vertex v4 = new Vertex(3, "4");
        Vertex v5 = new Vertex(4, "5");
        Vertex v6 = new Vertex(5, "6");
        Vertex v7 = new Vertex(6, "7");

        Edge e12 = new Edge(v1, v2, 2);
        Edge e13 = new Edge(v1, v3, 1);
        Edge e14 = new Edge(v1, v4, 2);
        v1.getEdges().addAll(Arrays.asList(e12, e13, e14));

        Edge e24 = new Edge(v2, v4, 3);
        v2.getEdges().addAll(Arrays.asList(e12, e24));

        Edge e34 = new Edge(v3, v4, 1);
        Edge e35 = new Edge(v3, v5, 2);
        v3.getEdges().addAll(Arrays.asList(e13, e34, e35));

        Edge e47 = new Edge(v4, v7, 2);
        v4.getEdges().addAll(Arrays.asList(e34, e14, e24, e47));

        Edge e56 = new Edge(v5, v6, 1);
        Edge e57 = new Edge(v5, v7, 3);
        v5.getEdges().addAll(Arrays.asList(e35, e56, e57));
        v6.getEdges().addAll(Collections.singletonList(e56));
        v7.getEdges().addAll(Arrays.asList(e57, e47));

        Graph g = new Graph();
        g.setEdges(Arrays.asList(e12, e13, e14, e24, e34, e35, e47, e56, e57));
        g.setVertices(Arrays.asList(v1, v2, v3, v4, v5, v6, v7));

        int minSpanningTree = findMinSpanningTree(g);
        System.out.println(minSpanningTree);
    }

    // this method finds the MST of a graph using Prim's Algorithm
    // returns the weight of the MST
    private static int findMinSpanningTree(Graph g) {
        int vertexCount = 0;
        int weight = 0;

        // add first vertex to the MST
        Vertex current = g.getVertices().get(0);
        current.setVisited(true);
        vertexCount++;

        // construct the remaining MST using the smallest weight edge
        while (vertexCount < g.getVertices().size()) {
            Edge smallest = null;

            for (int i = 0; i < current.edges.size(); i++) {
                if (!current.edges.get(i).isVisited()
                        && !current.edges.get(i).getDst().isVisited()) {
                    smallest = current.edges.get(i);
                    break;
                }
            }
            if (smallest != null) {
                for (int i = 0; i < current.edges.size(); i++) {
                    if (!current.edges.get(i).isVisited()) {
                        if (current.edges.get(i).getSrc().isVisited()
                                && !current.edges.get(i).getDst().isVisited()
                                && (current.edges.get(i).getWeight() < smallest.getWeight())) {
                            smallest = current.edges.get(i);
                        }
                    }
                }

                smallest.setVisited(true);
                smallest.getDst().setVisited(true);
                weight += smallest.getWeight();
                System.out.println(smallest);
            }
            vertexCount++;
        }
        return weight;
    }
}
