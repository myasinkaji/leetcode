package ir.home.tutorial.algorithm.leetcode.contest.weekly.weeklycontest228.q1;

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
                arguments(new int[]{5,3,6,1,12}, 3, 24),
                arguments(new int[]{-5,3,-6,-1,-12}, 3, 6),
                arguments(new int[]{2,7,9}, 4, 4)
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
    void testLeetcodeSampleArrays(int[] nums, int original, int expected) {
        final int rearrangedArray = solution.findFinalValue(nums, original);

        assertThat(rearrangedArray).isEqualTo(expected);
    }
}