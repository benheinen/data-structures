import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);

        String filename = sc.next();

        Graph<String> g = GraphUtils.createStringGraph(filename, false);

        BFSPaths<String> paths = null;
        while (sc.hasNext()) {
            String command = sc.next();
            if (command.equals("start")) {
                String s = sc.next();
                paths = new BFSPaths<String>(g, s);
            } else if (paths == null) {
                System.out.println("You must use the start command to create the paths.");
            } else if (command.equals("distance")) {
                String v = sc.next();
                if (!paths.hasPathTo(v)) {
                    System.out.printf("There is no path to %s.\n");
                } else {
                    System.out.printf("%s is distance %d\n", v, paths.distTo(v));
                }
            } else if (command.equals("path")) {
                String v = sc.next();
                if (!paths.hasPathTo(v)) {
                    System.out.printf("There is no path to %s.\n");
                } else {
                    for (String w : paths.pathTo(v)) {
                        System.out.printf("%s ", w);
                    }
                    System.out.println();
                }
            }
        }
        sc.close();
    }
}
