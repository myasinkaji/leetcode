package ir.home.tutorial.algorithm.leetcode.contest.weekly.weeklycontest280.p1;

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
                arguments(2, 3, 3),
                arguments(10, 10, 1),
                arguments(10, 10, 1),
                arguments(0, 100, 0),
                arguments(1, 10, 10)
        );
    }


    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("questionSampleArrays")
    void testQuestionSampleArrays(int num1, int num2, int expected) {
        final var actual = solution.countOperations(num1, num2);
        assertThat(actual).isEqualTo(expected);
    }
}