import java.util.Set;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wedding {
    public static Map<String, String> createCouple(Set<String> first, Set<String> second) {
        List<String> list1 = new ArrayList<>(first);
        List<String> list2 = new ArrayList<>(second);
        Collections.shuffle(list1);
        Collections.shuffle(list2);
        int size = Math.min(list1.size(), list2.size());
        Map<String, String> couples = new HashMap<>();
        for (int i = 0; i < size; i++) {
            couples.put(list1.get(i), list2.get(i));
        }

        return couples;
    }
}