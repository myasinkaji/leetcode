package ir.home.tutorial.algorithm.leetcode.questions.p763;

import org.junit.jupiter.api.BeforeEach;
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
                arguments("ababcbacadefegdehijhklij", List.of(9, 7, 8)),
                arguments("eccbbbbdec", List.of(10)),
                arguments("a", List.of(1)),
                arguments("ab", List.of(1, 1)),
                arguments("aba", List.of(3)),
                arguments("abac", List.of(3, 1)),
                arguments("abcdefgh", List.of(1, 1, 1, 1, 1, 1, 1, 1))
        );
    }

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("questionSampleArrays")
    void testQuestionSampleArrays(final String s, List<Integer> expected) {
        final var actual = solution.partitionLabels(s);
        assertThat(actual).containsExactlyElementsOf(expected);
    }
}