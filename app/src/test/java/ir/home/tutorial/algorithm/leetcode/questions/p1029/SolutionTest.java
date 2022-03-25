package ir.home.tutorial.algorithm.leetcode.questions.p1029;


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
                arguments(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}, 110),
                arguments(new int[][]{{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}}, 1859),
                arguments(new int[][]{{515, 563}, {451, 713}, {537, 709}, {343, 819}, {855, 779}, {457, 60}, {650, 359}, {631, 42}}, 3086)
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
    void testQuestionSampleArrays(final int[][] costs, final int expected) {
        final var actual = solution.twoCitySchedCost(costs);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("randomArray")
    void testRandomArrays(final int[][] costs, final int expected) {
        final var actual = solution.twoCitySchedCost(costs);
        assertThat(actual).isEqualTo(expected);
    }
}