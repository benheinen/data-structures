import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphUtils {

    // Read a graph with String vertices from a file.
    // Each line of the file represents an edge in this format
    //
    //      from to [weight]
    //
    // where `from` and `to` are Strings which are names of vertices,
    // and `weight` is an optional weight.  If `weight` is not
    // specified, 1.0 is used.
    public static Graph<String> createStringGraph(String filename, boolean directed)
            throws FileNotFoundException {

        FileInputStream inFile = new FileInputStream(filename);
        Scanner sc = new Scanner(inFile);

        Graph<String> g = new Graph<String>(directed);
        while (sc.hasNextLine()) {
            String[] fields = sc.nextLine().trim().split(" ");
            if (fields.length < 2) continue;
            String from = fields[0];
            String to = fields[1];
            double weight = fields.length > 2 ? Double.parseDouble(fields[2]) : 1.0;
            g.addEdge(from, to, weight);
        }

        sc.close();

        return g;
    }

    // Read a graph with Integer vertices from a file.
    // Each line of the file represents an edge in this format
    //
    //      from to [weight]
    //
    // where `from` and `to` are Strings which are names of vertices,
    // and `weight` is an optional weight.  If `weight` is not
    // specified, 1.0 is used.
    public static Graph<Integer> createIntegerGraph(String filename, boolean directed)
            throws FileNotFoundException {

        FileInputStream inFile = new FileInputStream(filename);
        Scanner sc = new Scanner(inFile);

        Graph<Integer> g = new Graph<Integer>(directed);
        while (sc.hasNextLine()) {
            String[] fields = sc.nextLine().trim().split(" ");
            if (fields.length < 2) continue;
            int from = Integer.parseInt(fields[0]);
            int to = Integer.parseInt(fields[1]);
            double weight = fields.length > 2 ? Double.parseDouble(fields[2]) : 1.0;
            g.addEdge(from, to, weight);
        }

        sc.close();

        return g;
    }
}
