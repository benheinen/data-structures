import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DFSPaths<V> {
    
    // Keep track of the graph and the starting vertex.  In the
    // real world, we'd be sure to create a copy of the graph,
    // since the Graph type is mutable.
    private Graph<V> g;
    private V s;

    // As vertices are marked they're added to this set.
    private Set<V> marked;

    // Keep track of where we came from for each vertex.
    private Map<V,V> from;

    private void DFSVisit(V v) {
        this.marked.add(v);
        for (Graph<V>.Edge e : g.adj(v)) {
            V w = e.getOther(v);
            if (!this.marked.contains(w)) { 
                this.from.put(w, v);
                DFSVisit(w);
            }
        }
    }

    // The strategy here is to run the DFS algorithm from the
    // constructor, and leave the data around for the other
    // methods to use.
    public DFSPaths(Graph<V> g, V s) {
        this.g = g;
        this.s = s;
        this.marked = new HashSet<V>();
        this.from = new HashMap<V, V>();

        DFSVisit(s);
        
    }

    public boolean hasPathTo(V v) {
        return this.marked.contains(v);
    }

    public Iterable<V> pathTo(V v) {
        if (!hasPathTo(v)) return null;
        
        // We're using our ArrayStack class because the Java Stack
        // class iterates the wrong way!
        ArrayStack<V> stk = new ArrayStack<V>(g.numVertices());
        for (V x = v; from.containsKey(x); x = from.get(x)) {
            stk.push(x);
        }
        stk.push(s);
        return stk;
    }
}
