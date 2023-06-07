package Exam18Aug2022;

import java.util.*;
import java.util.stream.Collectors;

public class Kat_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Long> platesList = Arrays.stream(scan.nextLine().split(", "))
                .map(Long::parseLong)
                .collect(Collectors.toList());
        ArrayDeque<Long> queuePlates = new ArrayDeque<>();
        for (Long plate : platesList) {
            queuePlates.offer(plate);
        }

        List<Long> carsList = Arrays.stream(scan.nextLine().split(", "))
                .map(Long::parseLong)
                .collect(Collectors.toList());
        Stack<Long> stackCars = new Stack<>();
        for (Long car : carsList) {
            stackCars.push(car);
        }
        long registeredCars = 0;
        long difference = 0;
        long capacity = 0;
        long days = 0;

        while (!stackCars.isEmpty() && !queuePlates.isEmpty()) {
            long lastCar = stackCars.peek();
            long firstPlate = queuePlates.peek();
            capacity = firstPlate / 2;
            if (lastCar == capacity) {
                registeredCars += stackCars.pop();
                queuePlates.poll();
            } else if (lastCar < capacity) {
                registeredCars += lastCar;
                difference = capacity - lastCar;
                queuePlates.poll();
                queuePlates.offer(difference * 2);
                stackCars.pop();
            } else {
                difference = lastCar - capacity;
                stackCars.pop();
                stackCars.push(difference);
                queuePlates.poll();
                registeredCars += capacity;
            }
            days++;
            difference = 0;
            capacity = 0;
        }

        System.out.printf("%d cars were registered for %d days!%n", registeredCars, days);
        if (!queuePlates.isEmpty()) {
            int sum = 0;
            for (Long plate : queuePlates) {
                sum += plate;
            }
            System.out.printf("%d license plates remain!%n", sum);
        }
        if (!stackCars.isEmpty()) {
            int sum = 0;
            for(Long car : stackCars){
                sum += car;
            }
            System.out.printf("%d cars remain without license plates!%n", sum);
        }
        if (stackCars.isEmpty() && queuePlates.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }


    }
}
