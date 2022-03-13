package ir.home.tutorial.algorithm.leetcode.questions.p20;


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
                arguments("{[]}", true),
                arguments("()", true),
                arguments("()[]{}", true),
                arguments("(]", false),
                arguments("(((((((([]))))))))", true),
                arguments("((((((((([]))))))))", false),
                arguments("((", false),
                arguments("){", false),
                arguments("(", false)
        );
    }

    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("questionSampleArrays")
    void testQuestionSampleArrays(final String s, final boolean expected) {
        final var actual = solution.isValid(s);
        assertThat(actual).isEqualTo(expected);
    }
}