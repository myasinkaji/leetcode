package ir.home.tutorial.algorithm.leetcode.questions.p121;

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
                arguments(new int[]{1, 2, 4}, 3),
                arguments(new int[]{1, 2, 7, 4}, 6),
                arguments(new int[]{7, 1, 5, 3, 6, 4}, 5),
                arguments(new int[]{7, 6, 4, 3, 1}, 0),
                arguments(new int[]{7, 100, 4, 300, 10}, 296),
                arguments(new int[]{7, -100, 4, 300, 10}, 400),
                arguments(new int[]{7, -100, 400, 300, 10}, 500),
                arguments(new int[]{-7, -100, -400, -300, -10}, 390),
                arguments(new int[]{7}, 0),
                arguments(new int[]{7, 7, 7, 7, 7}, 0),
                arguments(new int[]{3, 3, 5, 0, 0, 3, 1, 4}, 4),
                arguments(new int[]{11, 7, 1, 4, 2}, 3),
                arguments(new int[]{7, 100, 4, 30, 10}, 93)
        );
    }

    @ParameterizedTest
    @MethodSource("leetcodeSampleInput")
    void testLeetcodeSampleInput(int[] prices, int expected) {
        final int maxProfit = solution.maxProfit(prices);
        assertThat(maxProfit).isEqualTo(expected);
    }
}