package ir.home.tutorial.algorithm.leetcode.contest.biweekly.biweeklycontest73.p1;


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
                arguments(new int[]{1, 1}, 1, 1),
                arguments(new int[]{1, 100, 200, 1, 100}, 1, 100),
                arguments(new int[]{2, 2, 2, 2, 3}, 2, 2),
                arguments(new int[]{2, 2, 5, 456, 5, 4, 456, 46, 46, 63, 1, 65, 4654, 65, 631, 6354, 64, 65, 4, 16, 2, 5, 3}, 2, 5),
                arguments(new int[]{2, 3, 2, 4, 2, 5, 2, 6, 2, 3}, 2, 3)
        );
    }


    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("questionSampleArrays")
    void testQuestionSampleArrays(final int[] nums, final int key, final int expected) {
        final var actual = solution.mostFrequent(nums, key);
        assertThat(actual).isEqualTo(expected);
    }
}