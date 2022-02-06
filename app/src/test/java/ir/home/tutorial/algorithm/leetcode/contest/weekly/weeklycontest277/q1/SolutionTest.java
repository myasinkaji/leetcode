package ir.home.tutorial.algorithm.leetcode.contest.weekly.weeklycontest277.q1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    private static Solution solution;

    static Stream<Arguments> questionSampleArrays() {
        return Stream.of(
                arguments(new int[]{11, 7, 2, 15}, 2),
                arguments(new int[]{-3, 3, 3, 90}, 2)
        );
    }

    static Stream<int[]> withoutRepetitionArrays() {
        return Stream.of(
                //Ascending array without repetition
                IntStream.range(-100_000, 100_001).toArray(),
                //Descending array without repetition
                IntStream.range(-100_000, 100_001).map(i -> 100_001 - i + -100_000 - 1).toArray(),
                //unordered array without repetition
                shuffleArray(IntStream.range(-100_000, 100_001).toArray())
        );
    }

    static Stream<Arguments> completelyRandomArrays() {
        final var random = new Random();
        final var args = new Arguments[50];

        for (int n = 0; n < args.length; n++) {
            final int[] nums = new int[random.nextInt(1, 100)];
            for (int j = 0; j < nums.length; j++)
                nums[j] = random.nextInt(-100_000, 100_000);


            final int[] sortedNums = Arrays.stream(nums).sorted().toArray();
            int min = sortedNums[0];
            int max = sortedNums[sortedNums.length - 1];
            int minRepetitionCount = 0;
            int maxRepetitionCount = 0;
            for (int i = 1; i < sortedNums.length; i++) {
                if (min == sortedNums[i])
                    minRepetitionCount++;
                else break;
            }

            for (int i = sortedNums.length - 2; i >= 0; i--) {
                if (max == sortedNums[i])
                    minRepetitionCount++;
                else break;
            }

            int arrayBoundaries = min == max ? 1 : 2;
            args[n] = arguments(nums, (nums.length - arrayBoundaries - minRepetitionCount - maxRepetitionCount));
        }
        return Arrays.stream(args);
    }

    static int[] shuffleArray(int[] ar) {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }

    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    static Stream<Arguments> specialArrays() {
        return Stream.of(
                arguments(new int[]{}, 0),
                arguments(new int[0], 0),
                arguments(new int[5], 0),
                arguments(new int[]{1, 1, 1, 1, 1}, 0),
                arguments(new int[]{-1, -2, -1, -1, -2}, 0)
        );
    }

    @Test
    void tesLeetcodeWrong1() {
        final var nums = new int[]{723, 723, -423, 723, -647, 532, 723, 723, 212, -391, 723};
        final int actual = solution.countElements(nums);
        assertEquals(4, actual);
    }

    @Test
    void tesLeetcodeWrong2() {
        final var nums = new int[100];
        Arrays.fill(nums, 0);
        final int actual = solution.countElements(nums);
        assertEquals(0, actual);
    }

    @ParameterizedTest
    @MethodSource(value = "withoutRepetitionArrays")
    void when_thereIsNoRepeatAtAll_expect_lengthMinusTwo(int[] nums) {

        int count = solution.countElements(nums);

        assertEquals(nums.length - 2, count);
    }

    @ParameterizedTest
    @MethodSource("completelyRandomArrays")
    void testCompletelyRandomArrays(int[] nums, int expectedCount) {
        final int count = solution.countElements(nums);
        assertEquals(expectedCount, count);
    }

    @ParameterizedTest
    @MethodSource("specialArrays")
    void testSpecialArrays(int[] nums, int expected) {
        final int actual = solution.countElements(nums);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("questionSampleArrays")
    void testQuestionSampleArrays(int[] nums, int expected) {
        final int count = solution.countElements(nums);

        assertEquals(expected, count);
    }
}