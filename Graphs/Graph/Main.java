// Simple test client for Graph, using a Graph<String>.

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        if (args.length < 1) {
            System.out.println("usage: java GraphUtils <filename> [d|u]");
            System.out.println("    <filename> - file to read (required)");
            System.out.println("    [d|u] directed (default) or undirected");
            System.exit(0);
        }

        String filename = args[0];
        boolean directed = args.length > 1 && args[1].charAt(0) == 'd';

        Graph<String> g = GraphUtils.createStringGraph(filename, directed);
        for (String v : g.vertices()) {
            System.out.printf("%s : [ ", v);
            for (Graph<String>.Edge e : g.adj(v)) {
                System.out.printf("%s ", e.getOther(v));
            }
            System.out.println("]");
        }
    }
}
