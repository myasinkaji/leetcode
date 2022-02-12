package ir.home.tutorial.algorithm.leetcode.questions.p9;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {
    private static Solution solution;

    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    static Stream<Arguments> leetcodeSampleInput() {
        return Stream.of(
                arguments(121, true),
                arguments(-121, false),
                arguments(10, false),
                arguments(1001001, true),
                arguments(100110001, false)
        );
    }


    @ParameterizedTest
    @MethodSource("leetcodeSampleInput")
    void testLeetcodeSampleInput(int num, boolean expected) {
        final var actual = solution.isPalindrome(num);
        assertThat(actual).isEqualTo(expected);
    }
}