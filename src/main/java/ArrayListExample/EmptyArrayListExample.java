package ArrayListExample;

import java.util.ArrayList;
import java.util.List;

public class EmptyArrayListExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(20);
        numbers.set(0, 10);
        numbers.add(30);
        System.out.println(numbers);

        for (Integer number : numbers) {
            System.out.println(number);
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
    }
}
