package ir.home.tutorial.algorithm.leetcode.contest.weekly.weeklycontest282.p1;


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
                arguments(new String[]{"pay", "attention", "practice", "attend"}, "at", 2),
                arguments(new String[]{"leetcode", "win", "loops", "success"}, "code", 0),
                arguments(new String[]{"aaaaaaa", "aaaaa", "aa", "aaa"}, "aaa", 3)
        );
    }


    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("questionSampleArrays")
    void testQuestionSampleArrays(String[] words, String pref, int expected) {
        final var actual = solution.prefixCount(words, pref);
        assertThat(actual).isEqualTo(expected);
    }
}