package ir.home.tutorial.algorithm.leetcode.questions.p560;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {
    private static Solution solution;

    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    static Stream<Arguments> leetcodeSampleInput() {
        return Stream.of(
                arguments(new int[]{1, 1, 1}, 2, 2),
                arguments(new int[]{1, 2, 3}, 3, 2),
                arguments(new int[]{0, 0, 0}, 0, 6),
                arguments(new int[]{1, -1, 0}, 0, 3),
                arguments(new int[]{1, 2, 3, 4, 5, 0, 5, 0, 3, 0, 5, 0}, 5, 11)
        );
    }

    @ParameterizedTest
    @MethodSource("leetcodeSampleInput")
    void testLeetcodeSampleInput(int[] nums, int k, int expected) {
        final var actual = solution.subarraySum(nums, k);
        assertThat(actual).isEqualTo(expected);
    }
}