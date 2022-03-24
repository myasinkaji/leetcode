package ir.home.tutorial.algorithm.leetcode.questions.p881;

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
                arguments(new int[]{5, 2, 2, 3, 1}, 5, 3),
                arguments(new int[]{1, 2}, 3, 1),
                arguments(new int[]{3, 2, 2, 1}, 3, 3),
                arguments(new int[]{3, 2, 2, 1, 2, 1}, 3, 4),
                arguments(new int[]{3, 1, 1, 2, 2}, 3, 3),
                arguments(new int[]{3, 5, 3, 4}, 5, 4)
        );
    }

    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("questionSampleArrays")
    void testQuestionSampleArrays(final int[] people, final int limit, final int expected) {
        final var actual = solution.numRescueBoats(people, limit);
        assertThat(actual).isEqualTo(expected);
    }
}