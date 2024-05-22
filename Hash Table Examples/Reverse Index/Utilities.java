
import java.util.HashMap;
import java.util.Map;

public class Utilities {

    public static Map<String,Integer> createReverseIndex(StateData[] stateData) {
        // use hashmap

        // create "reverse index" which is a map.
        HashMap<String, Integer> reverseIndex = new HashMap<>();
            for (int i = 0; i < stateData.length; i++) {
                reverseIndex.put(stateData[i].getName(), i);
            }
        return reverseIndex;
    }
}
