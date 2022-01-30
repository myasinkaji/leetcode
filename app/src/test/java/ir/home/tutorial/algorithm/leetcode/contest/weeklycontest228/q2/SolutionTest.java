package ir.home.tutorial.algorithm.leetcode.contest.weeklycontest228.q2;

import ir.home.tutorial.algorithm.RandomUtils;
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


    static Stream<Arguments> leetcodeSampleArrays() {
        return Stream.of(
                arguments(new int[]{0, 0, 1, 0}, List.of(2, 4)),
                arguments(new int[]{0, 0, 0}, List.of(3)),
                arguments(new int[]{1, 1}, List.of(0))
        );
    }

    static Stream<Arguments> randomArrays() {
        int n = 10;
        final var arguments = new Arguments[n];
        for (int i = 0; i < n; i++) {
            final var origin = RandomUtils.generateRandomLengthArray(50_000, 100_000, 0, 2);
            arguments[i] = arguments(origin, List.of(1, 2, 3));
        }
        return Stream.of(arguments);
    }

    @ParameterizedTest
    @MethodSource("leetcodeSampleArrays")
    void testLeetcodeSampleArrays(int[] nums, List<Integer> expected) {
        final var rearrangedArray = solution.maxScoreIndices(nums);

        assertThat(rearrangedArray).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("randomArrays")
    void testRandomArrays(int[] nums, List<Integer> expected) {
        final var rearranged = solution.maxScoreIndices(nums);
        //Todo assert result
//        assertThat(rearranged).isEqualTo(expected);
    }
}