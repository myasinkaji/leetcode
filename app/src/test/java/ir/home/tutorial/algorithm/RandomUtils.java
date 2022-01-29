package ir.home.tutorial.algorithm;

import java.util.HashSet;
import java.util.Random;
import java.util.function.IntPredicate;

public class RandomUtils {

    private static final Random random = new Random();

    public static int[] generateRandomLengthArray(int maxLength, int lowerBound, int upperBound) {
        return generateRandomLengthArray(0, maxLength, lowerBound, upperBound);
    }

    public static int[] generateRandomLengthArray(int minLength, int maxLength, int lowerBound, int upperBound) {
        final int[] nums = new int[random.nextInt(minLength, maxLength)];
        for (int j = 0; j < nums.length; j++)
            nums[j] = random.nextInt(lowerBound, upperBound);
        return nums;
    }

    public static int[] generateEvenLengthArray(int maxLength, int lowerBound, int upperBound, IntPredicate predicate) {
        return generateEvenLengthArray(0, maxLength, lowerBound, upperBound, predicate);
    }

    public static int[] generateEvenLengthArray(int minLength, int maxLength, int lowerBound, int upperBound, IntPredicate predicate) {
        final var length = random.nextInt(minLength, maxLength);
        final int[] nums = new int[length % 2 == 0 ? length : length - 1];
        for (int j = 0; j < nums.length; j++) {
            final int value = random.nextInt(lowerBound, upperBound);
            if (predicate.test(value))
                nums[j] = value;
            else j--;
        }
        return nums;
    }

    private static int negative(int i) {
        return Math.negateExact(Math.abs(i));
    }

    public static int[] generateEvenLengthEqualPositiveNegativeArray(int maxLength, int lowerBound, int upperBound) {
        return generateEvenLengthEqualPositiveNegativeArray(0, maxLength, lowerBound, upperBound);
    }

    public static int[] generateEvenLengthEqualPositiveNegativeArray(int minLength, int maxLength, int lowerBound, int upperBound) {
        if (maxLength % 2 != 0)
            throw new IllegalArgumentException("maxLength must be even.");

        final int[] nums = generateEvenLengthArray(minLength, maxLength, lowerBound, upperBound, i -> i != 0);
        final var halfLength = nums.length / 2;
        final var negativesIndexes = new HashSet<Integer>(halfLength);
        while (negativesIndexes.size() < halfLength)
            negativesIndexes.add(random.nextInt(nums.length));

        negativesIndexes.forEach(i -> nums[i] = negative(nums[i]));
        final var positivesIndexes = new HashSet<Integer>(halfLength);
        for (int i = 0; i < nums.length; i++)
            if (!negativesIndexes.contains(i))
                positivesIndexes.add(i);

        positivesIndexes.forEach(i -> nums[i] = Math.abs(nums[i]));

        return nums;
    }
}