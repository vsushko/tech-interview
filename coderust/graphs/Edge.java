package graphs;

public class Edge {
    /**
     * Source
     */
    private Vertex src;
    /**
     * destination
     */
    private Vertex dst;

    /**
     * edge's weight
     */
    private int weight;

    private boolean visited = false;

    public Edge(Vertex src, Vertex dst, int weight) throws IllegalArgumentException {
        if (src == null || dst == null || weight <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }
    }

    public Vertex getSrc() {
        return src;
    }

    public void setSrc(Vertex src) {
        this.src = src;
    }

    public Vertex getDst() {
        return dst;
    }

    public void setDst(Vertex dst) {
        this.dst = dst;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Edge [src=" + src + ", dst=" + dst + ", weight=" + weight + "]";
    }
}
