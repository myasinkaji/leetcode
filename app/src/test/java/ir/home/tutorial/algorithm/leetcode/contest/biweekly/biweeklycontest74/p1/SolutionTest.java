package ir.home.tutorial.algorithm.leetcode.contest.biweekly.biweeklycontest74.p1;

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
                arguments(new int[]{3, 2, 3, 2, 2, 2}, true),
                arguments(new int[]{3, 2, 3, 2, 2, 2, 4, 4}, true),
                arguments(new int[]{3, 2, 3, 2, 2, 2, 4, 4, 4, 5}, false),
                arguments(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, true),
                arguments(new int[]{1, 2, 3, 4}, false),
                arguments(new int[]{2, 3, 4, 5}, false),
                arguments(new int[]{2, 3}, false),
                arguments(new int[]{10,5,3,4,17,11,15,13,11,18,8,17,20,8,14,13,3,17,14,11,8,2,12,17,6,7,17,7,2,2,4,14,9,7}, false)
        );
    }


    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("questionSampleArrays")
    void testQuestionSampleArrays(final int[] nums, final boolean expected) {
        final var actual = solution.divideArray(nums);
        assertThat(actual).isEqualTo(expected);
    }
}