package T01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> numbersDeq = new ArrayDeque<>();
        int number = Integer.parseInt(scan.nextLine());
        if (number == 0) {
            System.out.println(0);
        } else {
            while (number != 0) {
                int leftPart = number % 2;
                numbersDeq.push(leftPart);
                number /= 2;

            }
            for (Integer integer : numbersDeq) {
                System.out.print(integer);
            }
        }
    }
}
