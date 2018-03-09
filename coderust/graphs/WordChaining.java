package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Figure out whether the given words can form a circular chain.
 * <p>
 * Runtime Complexity
 * - generate_graph: Quadratic, O(n2).
 * - check_cycle_rec: Factorial, O(n!).
 * The recurrence relation for time complexity is:
 * T(n) = O(n) + nT(n-1)T(n)=O(n)+nT(n−1)
 * Memory Complexity: Linear, O(n).
 * Recursive solution will consume memory on the stack as well.
 */
public class WordChaining {
}

class vertex {
    private char value;
    private boolean visited;
    private List<vertex> adjVertices;
    private List<vertex> inVertices;

    public vertex(char value, boolean visited) {
        this.value = value;
        this.visited = visited;
        adjVertices = new ArrayList<>();
        inVertices = new ArrayList<>();
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<vertex> getAdjVertices() {
        return adjVertices;
    }

    public List<vertex> getInVertices() {
        return inVertices;
    }
}

class graph {
    private List<vertex> g;

    public graph(List<vertex> g) {
        super();
        this.g = g;
    }

    public List<vertex> getG() {
        return g;
    }

    public void setG(List<vertex> g) {
        this.g = g;
    }

    // this method creates a graph from a list of words. A node of the graph
    // contains a character representing the start or end character of a word.
    void createGraph(List<String> wordsList) {
        for (String word : wordsList) {
            char startChar = word.charAt(0);
            char endChar = word.charAt(word.length() - 1);

            vertex start = vertexExists(startChar);
            if (start == null) {
                start = new vertex(startChar, false);
                g.add(start);
            }
            vertex end = vertexExists(endChar);
            if (end == null) {
                end = new vertex(endChar, false);
                g.add(end);
            }
            // add an edge from start vertex to end vertex
            addEdge(start, end);
        }
    }

    // this method returns the vertex with a given value if it
    // already exists in the graph, returns NULL otherwise
    private vertex vertexExists(char value) {
        for (vertex aG : g) {
            if (aG.getValue() == value) {
                return aG;
            }
        }
        return null;
    }

    // this method returs TRUE if all nodes of the graph have been visited
    private boolean allVisited() {
        for (int i = 0; i < getG().size(); i++) {
            if (!getG().get(i).isVisited()) {
                return false;
            }
        }
        return true;
    }

    // this method adds an edge from start vertex to end vertex by adding the end
    // vertex in the adjacency list of start vertex.
    // It also adds the start vertex to the inVertices of end vertex
    private void addEdge(vertex start, vertex end) {
        start.getAdjVertices().add(end);
        end.getInVertices().add(start);
    }

    // this method returns TRUE if out degree of each vertex is equal
    // to its in degree, returns FALSE otherwise
    private boolean outEqualsIn() {
        for (int i = 0; i < getG().size(); i++) {
            int out = getG().get(i).getAdjVertices().size();
            int in = getG().get(i).getInVertices().size();
            if (out != in) {
                return false;
            }
        }
        return true;
    }

    // this method returns TRUE if the graph has a cycle containing
    // all the nodes, returns FALSE otherwise
    private boolean checkCycleRec(vertex node, vertex startingNode) {
        node.setVisited(true);

        // base case
        // return TRUE if all nodes have been visited and there exists and edge
        // from te last node being visited to the starting node
        List<vertex> adj = node.getAdjVertices();
        if (allVisited()) {
            for (vertex anAdj : adj) {
                if (anAdj == startingNode) {
                    return true;
                }
            }
        }
        // recursive case
        for (vertex anAdj : adj) {
            if (!anAdj.isVisited()) {
                node = anAdj;
                if (checkCycleRec(node, startingNode)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkCycle(int listSize) {
        // empty list and single word cannot for a chain
        if (listSize < 2) {
            return false;
        }
        if (g.size() > 0) {
            if (outEqualsIn()) {
                return checkCycleRec(getG().get(0), getG().get(0));
            }
        }
        return false;
    }

    void printGraph() {
        for (vertex aG : g) {
            System.out.println(aG.getValue() + " "
                    + aG.isVisited() + "\n");
            List<vertex> adj = aG.getAdjVertices();

            for (vertex anAdj : adj) {
                System.out.println(anAdj.getValue() + " ");
            }
            System.out.println("\n");
        }
    }
}
