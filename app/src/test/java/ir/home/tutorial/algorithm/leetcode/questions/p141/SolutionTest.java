package ir.home.tutorial.algorithm.leetcode.questions.p141;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {
    private static Solution solution;

    static Stream<Arguments> questionSampleArrays() {
        return Stream.of(
                arguments(linkedList(1, 3, 2, 0, -4), true),
                arguments(linkedList(0, 1, 2), true),
                arguments(linkedList(null, 1), false),
                arguments(linkedList(null, 1, 2), false),
                arguments(null, false),
                arguments(linkedList(0, 1), true),
                arguments(linkedList(0, 1, 2, 3), true),
                arguments(linkedList(2, 1, 2, 3), true)
        );
    }

    private static ListNode linkedList(Integer cycleIndex, int... n) {
        final var head = new ListNode(n[0]);
        var tail = head;
        ListNode cycleNode = null;
        if (cycleIndex != null && cycleIndex == 0)
            cycleNode = tail;
        for (int i = 1; i < n.length; i++) {
            tail.next = new ListNode(n[i]);
            tail = tail.next;
            if (cycleIndex != null && cycleIndex == i)
                cycleNode = tail;
        }
        tail.next = cycleNode;
        return head;
    }


    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("questionSampleArrays")
    void testQuestionSampleArrays(final ListNode head, final boolean expected) {
        final var actual = solution.hasCycle(head);
        assertThat(actual).isEqualTo(expected);
    }
}