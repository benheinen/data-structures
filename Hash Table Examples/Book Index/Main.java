import java.io.*;
import java.util.*;

public class Main {

    private static HashSet<String> readExcludeList(String fileName) throws FileNotFoundException {

        HashSet<String> excludeList = new HashSet<>();

        Scanner excludeFile = new Scanner(new FileInputStream(fileName));
        while (excludeFile.hasNext()) {
            String s = excludeFile.next();
            excludeList.add(s);
        }

        excludeFile.close();
        return excludeList;
    }

    private static HashMap<String, TreeSet<Integer>> createIndex(String fileName, HashSet<String> excludeList) throws FileNotFoundException {

        HashMap<String, TreeSet<Integer>> index = new HashMap<>();

        Scanner text = new Scanner(new FileInputStream(fileName));
        int page = 1;
        while (text.hasNext()) {
            String word = text.next();
            if (word.equals("-----")) {
                page++;
                continue;
            }
            if (excludeList.contains(word)) {
                continue;
            }
            if (!index.containsKey(word)) {
                index.put(word, new TreeSet<>());
            }
            index.get(word).add(page);
        }

        text.close();

        return index;
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scnr = new Scanner(System.in);

        HashSet<String> excludeList = readExcludeList("exclude.txt");
        HashMap<String, TreeSet<Integer>> index = createIndex("paginatedtale.txt", excludeList);
		
        while (scnr.hasNext()) {
            String word = scnr.next();
			System.out.printf("%s: ", word);
            if (excludeList.contains(word)) {
                System.out.println("Excluded from search.");
            } else if (!index.containsKey(word)) {
                System.out.println("Not in text.");
            } else {
                TreeSet<Integer> pages = index.get(word);
                for (int pageNumber : pages) {
                    System.out.print(pageNumber + " ");
                }
                System.out.println();
            }
        }

        scnr.close();
    }
}
