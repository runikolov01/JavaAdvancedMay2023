package Exams.Exam14April2021;

import java.util.*;
import java.util.stream.Collectors;

public class Bouquets_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> tulips = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());
        Stack<Integer> stackTulips = new Stack<>();
        for (Integer t : tulips) {
            stackTulips.push(t);
        }

        List<Integer> daffodils = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (Integer d : daffodils) {
            queue.offer(d);
        }

        int counterBouqets = 0;
        int moreFlowers = 0;

        while (!stackTulips.isEmpty() && !queue.isEmpty()) {
            int currentTulip = stackTulips.peek();
            int currentDaff = queue.peek();
            int sum = currentTulip + currentDaff;

            if (sum == 15) {
                counterBouqets++;
                stackTulips.pop();
                queue.poll();
            } else if (sum < 15) {
                moreFlowers += sum;
                stackTulips.pop();
                queue.poll();

            } else if (sum > 15) {
                currentTulip -= 2;
                stackTulips.pop();
                stackTulips.push(currentTulip);

            }

        }
        if (moreFlowers >= 15) {
            int newBouq = moreFlowers / 15;
            counterBouqets += newBouq;
        }

        if (counterBouqets >= 5) {
            System.out.println("You made it! You go to the competition with " + counterBouqets + " bouquets!");
        } else {
            int diff = 5 - counterBouqets;
            System.out.println("You failed... You need more " + diff + " bouquets.");
        }
    }
}
