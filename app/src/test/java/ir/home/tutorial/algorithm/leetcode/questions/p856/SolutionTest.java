package ir.home.tutorial.algorithm.leetcode.questions.p856;

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
                arguments("()", 1),
                arguments("(())", 2),
                arguments("()()", 2),
                arguments("()()(())((()))()", 9),
                arguments("()()(())((()))()(()())", 13),
                arguments("()()(())((()))()(()()())", 15),
                arguments("()()(())((()))()(()(()(()))())", 25),
                arguments("(()(())()()(((()))))()()(())((()))()(()(()(()))())", 51)
        );
    }

    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("questionSampleArrays")
    void testQuestionSampleArrays(final String s, int expected) {
        final var actual = solution.scoreOfParentheses(s);
        assertThat(actual).isEqualTo(expected);
    }
}