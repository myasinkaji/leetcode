package ir.home.tutorial.algorithm.leetcode.contest.biweekly.biweeklycontest71.p1;

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
                arguments(2932, 52),
                arguments(4009, 13),
                arguments(1000, 1),
                arguments(9999, 198),
                arguments(9009, 18),
                arguments(1001, 2)
        );
    }


    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("questionSampleArrays")
    void testQuestionSampleArrays(final int num, int expected) {
        final var actual = solution.minimumSum(num);
        assertThat(actual).isEqualTo(expected);
    }
}