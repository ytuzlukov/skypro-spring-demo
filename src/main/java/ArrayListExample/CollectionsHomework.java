package ArrayListExample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionsHomework {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        System.out.println("Задание 1");
        for (int num : nums) {
            if (num%2!=0) {
                System.out.print(num + " ");
            }
        }
        System.out.println("\n");

        System.out.println("Задание 2");
        Set<Integer> numsSet = new HashSet<>();
        for (Integer num : nums) {
            if (num%2==0) {
                numsSet.add(num);
            }
        }
        nums = numsSet.stream().sorted().collect(Collectors.toList());
        System.out.println(nums + "\n");

        System.out.println("Задание 3");
        Set<String> stringsSet = new HashSet<>(List.of("безработный",
                "водитель",
                "плотник",
                "столяр",
                "актер",
                "актер"));
        System.out.println(stringsSet + "\n");

        System.out.println("Задание 4");

        String text = "безработный водитель плотник столяр актер актер безработный";

        List<String> professions = List.of(text.split(" "));

        List<String> professionsEmpty = new ArrayList<>(List.of(""
        ));

        int iter = 0;
        for (String profession : professions) {
            if (!professionsEmpty.contains(profession)) {
                professionsEmpty.add(profession);
            } else iter++;
        }
        System.out.println("Повторяющиеся слова = " + iter + "\n");
    }

}
