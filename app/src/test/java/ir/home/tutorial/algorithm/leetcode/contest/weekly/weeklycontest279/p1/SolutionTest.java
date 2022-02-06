package ir.home.tutorial.algorithm.leetcode.contest.weekly.weeklycontest279.p1;


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
                arguments(new int[]{4, 1, 2, 3, 0}, new int[]{0, 3, 2, 1, 4}),
                arguments(new int[]{4, 1, 2, 3}, new int[]{2, 3, 4, 1}),
                arguments(new int[]{4, 1, 2}, new int[]{2, 1, 4}),
                arguments(new int[]{2, 1}, new int[]{2, 1})
        );
    }


    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("questionSampleArrays")
    void testQuestionSampleArrays(final int[] nums, int[] expected) {
        final var actual = solution.sortEvenOdd(nums);
        assertThat(actual).isEqualTo(expected);
    }
}