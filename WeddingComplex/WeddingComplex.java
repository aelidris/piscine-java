import java.util.*;

public class WeddingComplex {

    public static Map<String, String> createBestCouple(Map<String, List<String>> first, Map<String, List<String>> second) {
        Map<String, String> engagements = new HashMap<>();
        Map<String, String> engagedTo = new HashMap<>();

        Queue<String> freeMen = new LinkedList<>(first.keySet());

        Map<String, Integer> proposalIndex = new HashMap<>();
        for (String man : first.keySet()) {
            proposalIndex.put(man, 0);
        }

        while (!freeMen.isEmpty()) {
            String man = freeMen.poll();
            List<String> prefs = first.get(man);

            int index = proposalIndex.get(man);
            String woman = prefs.get(index);
            proposalIndex.put(man, index + 1);

            if (!engagedTo.containsKey(woman)) {
                engagements.put(man, woman);
                engagedTo.put(woman, man);
            } else {
                String currentMan = engagedTo.get(woman);
                List<String> prefs2 = second.get(woman);

                if (prefs2.indexOf(man) < prefs2.indexOf(currentMan)) {
                    engagements.put(man, woman);
                    engagedTo.put(woman, man);
                    freeMen.add(currentMan);
                } else {
                    freeMen.add(man);
                }
            }
        }

        return engagements;
    }
}
