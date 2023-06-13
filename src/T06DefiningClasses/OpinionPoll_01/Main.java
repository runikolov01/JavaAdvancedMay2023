package T06DefiningClasses.OpinionPoll_01;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<Person> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] arr = scan.nextLine().split("\\s+");
            String name = arr[0];
            int age = Integer.parseInt(arr[1]);
            Person person = new Person(name, age);
            list.add(person);
        }
        list = list.stream().filter(person -> person.getAge() > 30).collect(Collectors.toList());
        list.sort(Comparator.comparing(person -> person.getName()));

        list.forEach(person -> System.out.println(person.toString()));


    }
}
