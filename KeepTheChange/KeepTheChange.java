import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class KeepTheChange {
    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        List<Integer> sort = coins.stream()
                .filter(coin -> coin <= amount)
                .sorted((a, b) -> b - a)
                .collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        int helper = amount;
        for (Integer coin : sort) {
            while (helper >= coin) {
                helper -= coin;
                result.add(coin);
            }
        }
        return result;
    }
}