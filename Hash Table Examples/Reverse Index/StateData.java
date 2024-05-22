import java.util.Comparator;
import java.util.Scanner;

public class StateData {

    private String name;
    private int population;
    private double density;

    private String stripQuotes(String s) {
        int start = s.charAt(0) == '"' ? 1 : 0;
        int len = s.length();
        int end = s.charAt(len-1) == '"' ? len-1 : len;
        return s.substring(start, end);
    }

    // Read an item from a Scanner object.
    public StateData(Scanner sc) {
        String line = sc.nextLine();
        String fields[] = line.split(",");
        if (fields.length != 9)
            throw new RuntimeException("Invalid input line: " + line);
        this.name = stripQuotes(fields[1]);
        this.population = Integer.parseInt(stripQuotes(fields[2]));
        this.density    = Double.parseDouble((stripQuotes(fields[8])));
    }

    public String getName() {
        return this.name;
    }

    public int getPopulation() {
        return this.population;
    }

    public double getDensity() {
        return this.density;
    }

    @Override
    public String toString() {
        return String.format("%20s %8d %8.2f", name, population, density);
    }

    private static class CompareByName implements Comparator<StateData> {

        @Override
        public int compare(StateData lhs, StateData rhs) {
            return lhs.name.compareTo(rhs.name);
        }
    }

    public static CompareByName getCompareByName() {
        return new CompareByName();
    }

    private static class CompareByDensity implements Comparator<StateData> {

        @Override
        public int compare(StateData lhs, StateData rhs) {
            return -((Double)lhs.density).compareTo(rhs.density);
        }
    }

    public static CompareByDensity getCompareByDensity() {
        return new CompareByDensity();
    }
}
