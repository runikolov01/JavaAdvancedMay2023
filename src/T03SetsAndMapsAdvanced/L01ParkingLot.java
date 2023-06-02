package T03SetsAndMapsAdvanced;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class L01ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Set<String> set = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] inpArr = input.split(", ");
            String command = inpArr[0];
            String car = inpArr[1];

            if (command.equals("IN")) {
                set.add(car);
            } else if (command.equals("OUT")) {
                set.remove(car);
            }

            input = scan.nextLine();
        }
        if (set.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : set) {
                System.out.println(car);
            }
        }
    }
}
