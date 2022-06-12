package ArrayListExample;

import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        Integer[] numbersArray = {1, 2, 3};
        List<Integer> numbersList = new ArrayList<>(List.of(9, 2, 3, 5));
        Map<String, Integer> numbersMap = new HashMap<>(Map.of("four", 4, "five", 5));
        Set<Integer> numbersSet = new HashSet<>(List.of(1, 2, 40, 12));

        numbersMap.put("two", 2);

        System.out.println(numbersArray[0]);
        System.out.println(numbersList.get(0));
        System.out.println(numbersMap.get("two"));

        numbersArray[1] = 10;
        numbersList.set(1, 10);
        numbersMap.put("one", 1);

        System.out.println(Arrays.toString(numbersArray));
        System.out.println(numbersList);
        System.out.println(numbersMap);
        System.out.println(numbersSet);


        System.out.println(numbersArray.length);
        System.out.println(numbersList.size());
        System.out.println(numbersMap.size());
        System.out.println(numbersSet.size());

        numbersList.add(56);
        numbersMap.put("three", 3);
        numbersSet.add(256);
        numbersSet.add(256);

        System.out.println(numbersList);
        System.out.println(numbersMap);
        System.out.println(numbersSet);
    }
}
