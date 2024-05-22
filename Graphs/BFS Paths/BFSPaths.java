import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BFSPaths<V> {
    
    // Keep track of the graph and the starting vertex.  In the
    // real world, we'd be sure to create a copy of the graph,
    // since the Graph type is mutable.
    private Graph<V> g;
    private V s;

    // As vertices are marked they're added to this set.
    private Set<V> marked;

    // Keep track of the distance to each vertex.
    private Map<V,Integer> dist;

    // Keep track of where we came from for each vertex.
    private Map<V,V> from;

    // The strategy here is to run the BFS algorithm from the
    // constructor, and leave the data around for the other
    // methods to use.
    public BFSPaths(Graph<V> g, V s) {
        this.g =g;
        this.s = s;

        this.marked = new HashSet<V>();
        this.dist = new HashMap<V, Integer>();
        this.from = new HashMap<V, V>();

        this.marked.add(s);
        this.dist.put(s, 0);

        ArrayQueue<V> q = new ArrayQueue<V>(g.numVertices());
        q.enqueue(s);

        while (!q.isEmpty()) {
            V v = q.dequeue(); 
            for (Graph<V>.Edge e : this.g.adj(v)) {
                V w = e.getOther(v);
                if (!this.marked.contains(w)) {
                    this.marked.add(w);
                    this.dist.put(w, this.dist.get(v) + 1);
                    this.from.put(w, v);
                    q.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(V v) {
        return this.marked.contains(v); 
    }

    public int distTo(V v) {
        if (!hasPathTo(v)) {
            return Integer.MAX_VALUE;
        }
        return this.dist.get(v);
    }

    public Iterable<V> pathTo(V v) {
        ArrayStack<V> stk = new ArrayStack<V>(g.numVertices());
        for (V x = v; this.from.containsKey(x); x = this.from.get(x)) {
            stk.push(x);
        }
        stk.push(s);
        return stk;
    }
}
