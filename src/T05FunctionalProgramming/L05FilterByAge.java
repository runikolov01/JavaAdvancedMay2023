package T05FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class L05FilterByAge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < number; i++) {
            String[] input = scan.nextLine().split(", ");
            String name = input[0];
            int personAge = Integer.parseInt(input[1]);
            map.put(name, personAge);
        }
        String condition = scan.nextLine();
        int ageLimit = Integer.parseInt(scan.nextLine());
        String type = scan.nextLine();
        BiPredicate<Integer, Integer> filterPredicate;

        if (condition.equals("younger")) {
            filterPredicate = (personAge, age) -> personAge <= age;
        } else {
            filterPredicate = (personAge, age) -> personAge >= age;
        }
        //филтрира според възрастовия лимит
        //принтира според шаблона

        Consumer<Map.Entry<String, Integer>> printConsumer;
        if (type.equals("age")) {
            printConsumer = person -> System.out.println(person.getValue());
        } else if (type.equals("name")) {
            printConsumer = person -> System.out.println(person.getKey());
        } else {
            printConsumer = person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
        }
        map.entrySet().stream()
                .filter(person -> filterPredicate.test(person.getValue(), ageLimit))
                .forEach(printConsumer);
    }
}
