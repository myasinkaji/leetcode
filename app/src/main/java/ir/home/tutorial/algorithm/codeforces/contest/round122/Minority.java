package ir.home.tutorial.algorithm.codeforces.contest.round122;

import java.util.Scanner;

public class Minority {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final int testCaseCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < testCaseCount; i++) {
            final var binaryString = scanner.nextLine();
            int length = binaryString.length();
            if (length <= 2)
                System.out.println(0);
            else {
                int ones = 0;
                for (int j = 0; j < length; j++)
                    if (binaryString.charAt(j) == '1')
                        ones++;
                if (ones == length - ones) {
                    System.out.println(ones - 1);
                } else {
                    System.out.println(Math.min(ones, length - ones));
                }
            }
        }
    }
}
