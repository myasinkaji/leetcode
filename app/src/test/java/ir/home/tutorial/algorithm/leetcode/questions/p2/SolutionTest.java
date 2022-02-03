package ir.home.tutorial.algorithm.leetcode.questions.p2;

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
//                arguments(linkedList(2, 4, 3), linkedList(5, 6, 4), linkedList(7, 0, 8)),
//                arguments(linkedList(0), linkedList(0), linkedList(0)),
//                arguments(linkedList(9, 9, 9, 9, 9, 9, 9), linkedList(9, 9, 9, 9), linkedList(8, 9, 9, 9, 0, 0, 0, 1)),
//                arguments(linkedList(9, 9, 9, 9), linkedList(9, 9, 9, 9, 9, 9, 9), linkedList(8, 9, 9, 9, 0, 0, 0, 1)),
//                arguments(linkedList(1, 1, 1, 1), linkedList(0), linkedList(1, 1, 1, 1)),
//                arguments(linkedList(1, 1, 1, 1), linkedList(1, 1, 1, 1), linkedList(2, 2, 2, 2)),
//                arguments(linkedList(1, 1, 1, 1), linkedList(9, 9, 9, 9), linkedList(0, 1, 1, 1, 1)),
                arguments(linkedList(1, 2, 3, 4, 5, 6, 7, 8, 9), linkedList(9, 8, 7, 6, 5, 4, 3, 2, 1), linkedList(0, 1, 1, 1, 1, 1, 1, 1, 1, 1)),
                arguments(linkedList(8, 9), linkedList(9, 8), linkedList(7, 8, 1)),
                arguments(linkedList(9, 8, 7), linkedList(7, 8, 9), linkedList(6, 7, 7, 1))
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
    void testQuestionSampleArrays(final ListNode first, final ListNode second, final ListNode expected) {
        final var actual = solution.addTwoNumbers(first, second);
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