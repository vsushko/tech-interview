package graphs;

import java.util.LinkedList;
import java.util.List;

public class Graph {

    private final String[] LABELS = {"A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "K", "M"};
    private List<Edge> edges = new LinkedList<>();
    private List<Vertex> vertices = new LinkedList<>();

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }
}