
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {

    private static void test(StateData[] stateData, Scanner sc) {

        Map<String, Integer> reverseIndex = Utilities.createReverseIndex(stateData);
        while (sc.hasNextLine()) {
            String state = sc.nextLine();
            if (state.length() == 0)
                continue;
            if (state.equals("end"))
                break;
            int idx = reverseIndex.get(state);
            System.out.printf("Rank: %2d    Data: %s\n", idx + 1, stateData[idx]);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<StateData> stateDataList = new ArrayList<>();

        try (FileInputStream stateDataFile = new FileInputStream("StatePopulationData.csv")) {
            Scanner sc = new Scanner(stateDataFile);
            sc.nextLine(); // skip header
            while (sc.hasNextLine()) {
                stateDataList.add(new StateData(sc));
            }
        } catch (IOException ex) {
            System.out.println(String.format("Error opening file: %d", ex.getMessage()));
            System.exit(-1);
        }
        System.out.printf("%d states read\n", stateDataList.size());
        StateData[] stateData = new StateData[stateDataList.size()];
        stateDataList.toArray(stateData);

        Scanner sc = new Scanner(System.in);

        System.out.println("Sorted by population");
        test(stateData, sc);

        Arrays.sort(stateData, StateData.getCompareByName());
        System.out.println("Sorted by name");
        test(stateData, sc);

        Arrays.sort(stateData, StateData.getCompareByDensity());
        System.out.println("Sorted by density");
        test(stateData, sc);

        sc.close();
    }
}
