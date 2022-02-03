package ir.home.tutorial.algorithm.leetcode.questions.p1;

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
                arguments(new int[]{-3, 4, 3, 90}, 0, new int[]{0, 2}),
                arguments(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                arguments(new int[]{3, 7, 2, 15}, 9, new int[]{1, 2}),
                arguments(new int[]{30, 70, 20, 150, 4400, 200, 300, 3000, 300, 3300, 300, 300, 1, 2}, 3, new int[]{12, 13}),
                arguments(new int[]{3, 2, 4, 100}, 6, new int[]{1, 2}),
                arguments(new int[]{10, 10, 10, 3, 3, 10, 10, 10, 10}, 6, new int[]{3, 4}),
                arguments(new int[]{3, 3}, 6, new int[]{0, 1})
        );
    }


    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("questionSampleArrays")
    void testQuestionSampleArrays(int[] nums, int target, int[] expected) {
        final int[] indices = solution.twoSum(nums, target);

        assertThat(indices).contains(expected);
    }
}