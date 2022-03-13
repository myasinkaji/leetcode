package ir.home.tutorial.algorithm.leetcode.questions.p6031;

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

    static Stream<Arguments> leetcodeSampleInput() {
        return Stream.of(
                arguments(new int[]{3, 4, 9, 1, 3, 9, 5}, 9, 1, List.of(1, 2, 3, 4, 5, 6)),
                arguments(new int[]{2, 2, 2, 2, 2}, 2, 2, List.of(0, 1, 2, 3, 4)),
                arguments(new int[]{1, 2, 3, 4, 5, 6}, 6, 100, List.of(0, 1, 2, 3, 4, 5)),
                arguments(new int[]{2}, 2, 2, List.of(0))
        );
    }

    @ParameterizedTest
    @MethodSource("leetcodeSampleInput")
    void testLeetcodeSampleInput(int[] nums, int key, int k, List<Integer> expected) {
        final var actual = solution.findKDistantIndices(nums, key, k);
        assertThat(actual).containsExactlyElementsOf(expected);
    }
}