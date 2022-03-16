package ir.home.tutorial.algorithm.leetcode.questions.p946;

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
                arguments(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}, true),
                arguments(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}, false),
                arguments(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}, true),
                arguments(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}, true),
                arguments(new int[]{1, 2, 3, 4, 5}, new int[]{2, 1, 4, 3, 5}, true)
        );
    }

    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("questionSampleArrays")
    void testQuestionSampleArrays(final int[] pushed, final int[] popped, boolean expected) {
        final var actual = solution.validateStackSequences(pushed, popped);
        assertThat(actual).isEqualTo(expected);
    }
}