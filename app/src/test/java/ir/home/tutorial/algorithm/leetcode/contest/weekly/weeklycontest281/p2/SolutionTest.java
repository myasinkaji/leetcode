package ir.home.tutorial.algorithm.leetcode.contest.weekly.weeklycontest281.p2;

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
                arguments(linkedList(0, 3, 1, 0, 4, 5, 2, 0), linkedList(4, 11)),
                arguments(linkedList(0, 1, 0, 3, 0, 2, 2, 0), linkedList(1, 3, 4)),
                arguments(linkedList(0, 1, 1, 1, 1, 0, 3, 3, 0), linkedList(4, 6))
        );
    }

    private static ListNode linkedList(int... n) {
        final var head = new ListNode(n[0]);
        var tail = head;
        for (int i = 1; i < n.length; i++) {
            tail.next = new ListNode(n[i]);
            tail = tail.next;
        }
        return head;
    }


    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("questionSampleArrays")
    void testQuestionSampleArrays(final ListNode first, final ListNode expected) {
        final var actual = solution.mergeNodes(first);
        var actualTail = actual;
        var expectedTail = expected;
        while (expectedTail != null) {
            assertThat(expectedTail.val).isEqualTo(actualTail.val);
            actualTail = actualTail.next;
            expectedTail = expectedTail.next;
        }

        assertThat(actualTail).overridingErrorMessage("length of actual is not the same as expected").isNull();
    }
}