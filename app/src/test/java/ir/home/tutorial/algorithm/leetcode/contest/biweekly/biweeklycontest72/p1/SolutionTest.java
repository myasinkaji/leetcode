package ir.home.tutorial.algorithm.leetcode.contest.biweekly.biweeklycontest72.p1;

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
                arguments(new int[]{3, 1, 2, 2, 2, 1, 3}, 2, 4),
                arguments(new int[]{1, 2, 3, 4}, 1, 0),
                arguments(new int[]{1, 1, 1, 1}, 1, 6)
        );
    }


    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("questionSampleArrays")
    void testQuestionSampleArrays(final int[] nums, int k, int expected) {
        final var actual = solution.countPairs(nums, k);
        assertThat(actual).isEqualTo(expected);
    }
}