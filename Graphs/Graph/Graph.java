
import java.util.ArrayList;
import java.util.HashMap;

// The type parameter V should be immutable.

public class Graph<V> {

    public class Edge {
        final private V from;
        final private V to;
        final private double weight;

        Edge(V from, V to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int hashCode() {
            // Following the pattern from _Algorithms, 4th Edition_, page 462.
            // It may be useful to able to identify an edge uniquely by
            // its `from` and `to` vertices, so the `weight` instance variable
            // is not included in the hash.
            // If we decide to support parallel edges, we'll have to revisit
            // this decision.
            int hash = 17;
            hash = hash * 31 + from.hashCode();
            hash = hash * 31 + to.hashCode();
            // hash = hash * 31 + ((Double) weight).hashCode();
            return hash;
        }

        public V getFrom() {
            return from;
        }

        public V getTo() {
            return to;
        }

        public V getOther(V v) {
            if (v.equals(to)) {
                return from;
            } else if (v.equals(from)) {
                return to;
            }

            // We should never get here!
            return null;
        }

        public double weight() {
            return weight;
        }
    }

    private HashMap<V, ArrayList<Edge>> adjList = new HashMap<V, ArrayList<Edge>>();
    private int numEdges = 0;
    private boolean directed = false;

    public Graph(boolean directed) {
        this.directed = directed;
    }

    public int numVertices() {
        return this.adjList.size();
    }

    public int numEdges() {
        return numEdges;
    }

    public void addEdge(V from, V to, double weight) {
        if (!this.adjList.containsKey(from)) {
            this.adjList.put(from, new ArrayList<Edge>());
        }

        if (!this.adjList.containsKey(to)) {
            this.adjList.put(to, new ArrayList<Edge>());
        }

        Edge e = new Edge(from, to, weight);
        this.adjList.get(from).add(e);
        if (!this.directed) {
            this.adjList.get(to).add(e);
        }
        numEdges += 1;
    }

    public void addEdge(V from, V to) {
        this.addEdge(from, to, 1.0);
    }

    // Allow iteration over the vertices.
    public Iterable<V> vertices() {
        return adjList.keySet();
    }

    // Allow iteration over the edges adjacent to the given vertex.
    public Iterable<Edge> adj(V v) {
        return adjList.get(v);
    }
}
