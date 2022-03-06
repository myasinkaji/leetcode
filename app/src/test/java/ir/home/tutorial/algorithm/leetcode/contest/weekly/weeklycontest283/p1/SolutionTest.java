package ir.home.tutorial.algorithm.leetcode.contest.weekly.weeklycontest283.p1;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {
    private static Solution solution;

    static Stream<Arguments> questionSampleArrays() {
        return Stream.of(
                arguments("K1:L2", List.of("K1","K2","L1","L2")),
                arguments("A1:F1", List.of("A1","B1","C1","D1","E1","F1"))
        );
    }


    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("questionSampleArrays")
    void testQuestionSampleArrays(String s, List<String> expected) {
        final var actual = solution.cellsInRange(s);
        assertThat(actual).containsExactly(expected.toArray(String[]::new));
    }
}