package ir.home.tutorial.algorithm.codeforces.contest.round122;

import java.util.Scanner;

public class ADiv7 {

    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final int testCaseCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < testCaseCount; i++) {
            final var number = scanner.nextLine();
            int transformedNumber = Integer.parseInt(number);
            if (transformedNumber % 7 != 0) {
                transformedNumber = Integer.parseInt(number.substring(0, number.length() - 1) + "0");
                while (transformedNumber % 7 != 0) {
                    transformedNumber++;
                }
            }
            System.out.println(transformedNumber);
        }
    }
}
