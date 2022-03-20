package ir.home.tutorial.algorithm.leetcode.questions.p895;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {
    private static FreqStack solution;

    static Stream<Arguments> questionSampleArrays() {
        return Stream.of(
                arguments(new int[]{5, 7, 5, 7, 4, 5}, new int[]{5, 7, 5, 4, 7, 5}),
                arguments(new int[]{1, 4, 0, 9, 3, 4, 2}, new int[]{4, 2, 3, 9, 0, 4, 1})
        );
    }

    @BeforeEach
     void setUp() {
        solution = new FreqStack();
    }

    @ParameterizedTest
    @MethodSource("questionSampleArrays")
    void testQuestionSampleArrays(final int[] pushed, final int[] popped) {
        Arrays.stream(pushed).forEach(solution::push);
        final boolean b = Arrays.stream(popped).allMatch(pop -> solution.pop() == pop);
        assertThat(b).isTrue();
    }

    /*
    Input: ["FreqStack","push","push","push","push","push","push","pop","push","pop","push","pop","push","pop","push","pop","pop","pop","pop","pop","pop"]
           [[],[4],[0],[9],[3],[4],[2],[],[6],[],[1],[],[1],[],[4],[],[],[],[],[],[]]

    Expected: [null,null,null,null,null,null,null,4,null,6,null,1,null,1,null,4,2,3,9,0,4]
    */
    @Test
    void test() {
        Arrays.stream(new int[]{4, 0, 9, 3, 4, 2}).forEach(solution::push);
        assertThat(solution.pop()).isEqualTo(4);
        solution.push(6);
        assertThat(solution.pop()).isEqualTo(6);
        solution.push(1);
        assertThat(solution.pop()).isEqualTo(1);
        solution.push(1);
        assertThat(solution.pop()).isEqualTo(1);
        solution.push(4);

        assertThat(solution.pop()).isEqualTo(4);
        assertThat(solution.pop()).isEqualTo(2);
        assertThat(solution.pop()).isEqualTo(3);
        assertThat(solution.pop()).isEqualTo(9);
        assertThat(solution.pop()).isEqualTo(0);
        assertThat(solution.pop()).isEqualTo(4);
    }
}