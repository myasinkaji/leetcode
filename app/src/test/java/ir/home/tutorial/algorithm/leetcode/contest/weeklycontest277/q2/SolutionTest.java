package ir.home.tutorial.algorithm.leetcode.contest.weeklycontest277.q2;

import ir.home.tutorial.algorithm.RandomUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    private static Solution solution;

    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }


    static Stream<Arguments> leetcodeSampleArrays() {
        return Stream.of(
                arguments(new int[]{3, 1, -2, -5, 2, -4}, new int[]{3, -2, 1, -5, 2, -4}),
                arguments(new int[]{-1, 1}, new int[]{1, -1})
        );
    }

    static Stream<Arguments> randomArrays() {
        int n = 10;
        final var arguments = new Arguments[n];
        for (int i = 0; i < n; i++) {
            final var origin = RandomUtils.generateEvenLengthEqualPositiveNegativeArray(50_000, 100_000, -100_000, 100_000);
            arguments[i] = arguments(origin, rearrangeArray(origin));
        }
        return Stream.of(arguments);
    }

    private static int[] rearrangeArray(int[] nums) {
        final var positives = new LinkedList<Integer>();
        final var negatives = new LinkedList<Integer>();
        for (int num : nums)
            if (num < 0)
                negatives.add(num);
            else
                positives.add(num);
        if (negatives.size() != positives.size())
            return null;
        for (int i = 0; i < (nums.length / 2); i++) {
            nums[2 * i] = positives.remove();
            nums[2 * i + 1] = negatives.remove();
        }
        return nums;
    }

    @ParameterizedTest
    @MethodSource("leetcodeSampleArrays")
    void testLeetcodeSampleArrays(int[] original, int[] expected) {
        final int[] rearrangedArray = solution.rearrangeArray(original);

        assertThat(rearrangedArray).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("randomArrays")
    void testRandomArrays(int[] original, int[] expected) {
        final var rearranged = solution.rearrangeArray(original);
        assertThat(rearranged).isEqualTo(expected);
    }
}