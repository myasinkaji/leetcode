package ir.home.tutorial.algorithm.leetcode.questions.p1007;

import org.junit.jupiter.api.BeforeEach;
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
                arguments(new int[]{6, 1, 6, 4, 6, 6}, new int[]{5, 2, 2, 6, 3, 6}, -1),
                arguments(new int[]{6, 1, 6, 4, 6, 6}, new int[]{5, 6, 2, 6, 3, 6}, 2),
                arguments(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}, 2),
                arguments(new int[]{2, 2, 2, 3, 3}, new int[]{2, 2, 2, 5, 5}, -1),
                arguments(new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2, 1}, 5),
                arguments(new int[]{1, 2, 2, 1, 1, 2, 1, 2, 1, 2}, new int[]{2, 1, 1, 2, 2, 1, 2, 1, 2, 1}, 5),
                arguments(new int[]{1, 2, 2, 2, 1, 2, 1, 2, 1, 2}, new int[]{2, 1, 1, 1, 2, 1, 2, 1, 2, 1}, 4),
                arguments(new int[]{1, 2, 1, 2, 6, 2, 6, 2, 6, 2}, new int[]{2, 1, 2, 1, 2, 6, 2, 6, 2, 6}, 5),
                arguments(new int[]{1, 2, 1, 2, 6, 2, 6, 2, 6, 2}, new int[]{2, 1, 2, 1, 2, 6, 2, 2, 2, 2}, 3),
                arguments(new int[]{1, 2, 1, 2, 6, 2, 6, 2, 6, 2}, new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, 0),
                arguments(new int[]{1, 2, 1, 2, 6, 2, 6, 2, 6, 2}, new int[]{2, 1, 2, 2, 2, 2, 2, 2, 2, 2}, 1),
                arguments(new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, 0),
                arguments(new int[]{1, 2, 1, 2, 6, 2, 6, 2, 6, 2}, new int[]{2, 1, 2, 1, 2, 1, 2, 6, 2, 6}, 5),
                arguments(new int[]{1, 2, 1, 2, 6, 2, 6, 2, 6, 2}, new int[]{2, 6, 2, 6, 2, 6, 2, 6, 2, 6}, 5),
                arguments(new int[]{2, 2, 2, 2, 6, 2, 6, 2, 6, 2}, new int[]{2, 6, 2, 6, 2, 6, 2, 6, 2, 6}, 3)
        );
    }

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("questionSampleArrays")
    void testQuestionSampleArrays(final int[] tops, final int[] bottoms, int expected) {
        final var actual = solution.minDominoRotations(tops, bottoms);
        assertThat(actual).isEqualTo(expected);
    }
}