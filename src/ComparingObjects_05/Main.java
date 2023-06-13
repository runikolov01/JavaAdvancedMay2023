package ComparingObjects_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Person> peopleList = new ArrayList<>();
        int countAllPeople = 0;

        while (!input.equals("END")) {
            String[] arr = input.split("\\s+");
            String name = arr[0];
            int age = Integer.parseInt(arr[1]);
            String town = arr[2];
            Person person = new Person(name, age, town);
            peopleList.add(person);
            countAllPeople++;
            input = scan.nextLine();
        }
        int n = Integer.parseInt(scan.nextLine());

        Person searchedPerson = peopleList.get(n - 1);
        peopleList.remove(n - 1);

        int count = 0; // брой на хората, еднакви със searchedPerson

        for (Person person : peopleList) {
            if (searchedPerson.compareTo(person) == 0) {
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", count + 1, countAllPeople - (count + 1), countAllPeople);
        }


    }
}
