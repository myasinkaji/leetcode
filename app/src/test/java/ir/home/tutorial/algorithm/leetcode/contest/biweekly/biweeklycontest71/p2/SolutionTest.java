package ir.home.tutorial.algorithm.leetcode.contest.biweekly.biweeklycontest71.p2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {
    private static Solution solution;

    static Stream<Arguments> questionSampleArrays() {
        return Stream.of(
                arguments(new int[]{9,12,5,10,14,3,10}, 10, new int[]{9,5,3,10,10,12,14}),
                arguments(new int[]{-3,4,3,2}, 2, new int[]{-3,2,4,3})
        );
    }


    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("questionSampleArrays")
    void testQuestionSampleArrays(final int[] nums, int pivot, int[] expected) {
        final var actual = solution.pivotArray(nums, pivot);
        assertThat(actual).isEqualTo(expected);
    }
}