package ir.home.tutorial.algorithm.leetcode.questions.p438;

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

    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    private static Stream<Arguments> leetcodeSampleInput() {
        return Stream.of(
                arguments("cbaebabacd", "abc", List.of(0, 6)),
                arguments("abab", "ab", List.of(0, 1, 2)),
                arguments("aaaaabbbbbaabbaabbaaabbb", "aaa", List.of(0, 1, 2, 18)),
                arguments("cabbefbacbaebclcblcbac", "abc", List.of(0, 6, 7, 8, 18, 19)),
                arguments("azqbalababaa", "baa", List.of(6, 8, 9)),
                arguments("abaqstaba", "baa", List.of(0, 6)),
                arguments("abbqaaabbaa", "baa", List.of(5, 8)),
                arguments("azazazazazazazazazazazazazaz", "baa", List.of()),
                arguments("a", "a", List.of(0))
        );
    }

    @ParameterizedTest
    @MethodSource("leetcodeSampleInput")
    void testLeetcodeSampleInput(String s, String p, List<Integer> expected) {
        final var actual = solution.findAnagrams(s, p);
        assertThat(actual).hasSameElementsAs(expected);
    }
}