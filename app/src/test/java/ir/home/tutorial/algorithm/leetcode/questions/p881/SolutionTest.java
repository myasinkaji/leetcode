package ir.home.tutorial.algorithm.leetcode.questions.p881;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {
    private static Solution solution;

    static Stream<Arguments> questionSampleArrays() {
        return Stream.of(
                arguments(new int[]{5, 2, 2, 3, 1}, 5, 3),
                arguments(new int[]{1, 2}, 3, 1),
                arguments(new int[]{3, 2, 2, 1}, 3, 3),
                arguments(new int[]{3, 2, 2, 1, 2, 1}, 3, 4),
                arguments(new int[]{3, 1, 1, 2, 2}, 3, 3),
                arguments(new int[]{3, 5, 3, 4}, 5, 4),
                arguments(new int[]{5, 5, 5, 4, 4, 4, 3, 3, 2, 2, 2, 2, 2, 1, 1, 1}, 6, 8),
                arguments(new int[]{5, 5, 5, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1}, 6, 8),
                arguments(new int[]{6, 6, 5, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1}, 6, 9),
                arguments(new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1}, 6, 8),
                arguments(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 6, 8)
        );
    }

    static Stream<Arguments> randomArray() {
        final var list = new ArrayList<Arguments>();
        final var random = new Random();
        final int maxLength = 5 * 10_000;
        final int maxLimit = 3 * 10_000;
        for (int i = 0; i < 1000; i++) {
            final int length = random.nextInt(maxLength);
            final int limit = random.nextInt(maxLimit);
            final var people = new int[length];
            for (int j = 0; j < length; j++)
                people[j] = random.nextInt(limit);
            list.add(arguments(people, limit, numRescueBoats(people, limit)));
        }
        return list.stream();
    }
    static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int ans = 0;

        while (i <= j) {
            ans++;
            if (people[i] + people[j] <= limit)
                i++;
            j--;
        }

        return ans;
    }

    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("questionSampleArrays")
    void testQuestionSampleArrays(final int[] people, final int limit, final int expected) {
        final var actual = solution.numRescueBoats(people, limit);
        assertThat(actual).isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource("randomArray")
    void testRandomArrays(final int[] people, final int limit, final int expected) {
        final var actual = solution.numRescueBoats(people, limit);
        assertThat(actual).isEqualTo(expected);
    }
}