package ir.home.tutorial.algorithm.leetcode.questions.p1249;

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
                arguments("(a(b(c)d)", "a(b(c)d)"),
                arguments("lee(t(c)o)de)", "lee(t(c)o)de"),
                arguments("a)b(c)d", "ab(c)d"),
                arguments("))((", ""),
                arguments("a))(())(a)b(sd)f)df(sfd)fsd(f)b(c)d", "a(())(a)b(sd)fdf(sfd)fsd(f)b(c)d")
        );
    }

    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("questionSampleArrays")
    void testQuestionSampleArrays(final String absolutePath, final String expected) {
        final var actual = solution.minRemoveToMakeValid(absolutePath);
        assertThat(actual).isEqualTo(expected);
    }
}