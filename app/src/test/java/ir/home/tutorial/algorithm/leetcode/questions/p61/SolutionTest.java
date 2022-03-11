package ir.home.tutorial.algorithm.leetcode.questions.p61;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {
    private static Solution solution;

    static Stream<Arguments> questionSampleArrays() {
        return Stream.of(
                arguments(linkedList(1, 2, 3, 4, 5), 2, linkedList(4, 5, 1, 2, 3)),
                arguments(linkedList(0, 1, 2), 4, linkedList(2, 0, 1)),
                arguments(linkedList(1, 1, 1, 1, 1, 1, 1), 500000000, linkedList(1, 1, 1, 1, 1, 1, 1)),
                arguments(linkedList(1), 500000000, linkedList(1)),
                arguments(linkedList(1), 0, linkedList(1)),
                arguments(linkedList(1, 2, 3, 4), 400000000, linkedList(1, 2, 3, 4)),
                arguments(null, 500000000, null)
//                arguments(linkedList(-1, 1, 1, 2, 3), linkedList(-1, 2, 3)),
//                arguments(linkedList(-3, -1, 0, 0, 0, 3, 3), linkedList(-3, -1)),
//                arguments(linkedList(-3, -1, 0, 3, 3, 4), linkedList(-3, -1, 0, 4))
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
    void testQuestionSampleArrays(final ListNode head, int k, final ListNode expected) {
        final var actual = solution.rotateRight(head, k);
        var actualTail = actual;
        var expectedTail = expected;
        for (; expectedTail != null; actualTail = actualTail.next, expectedTail = expectedTail.next) {
            if (actualTail.val != expectedTail.val) {
                final var actualList = new StringBuilder();
                final var expectedList = new StringBuilder();
                for (actualTail = actual; actualTail != null; actualTail = actualTail.next)
                    actualList.append(actualTail.val).append(", ");

                for (expectedTail = expected; expectedTail != null; expectedTail = expectedTail.next)
                    expectedList.append(expectedTail.val).append(", ");

                fail("actual: %s\nexpected to be: %s", actualList.toString(), expectedList.toString());
            }
        }

        assertThat(actualTail).overridingErrorMessage("length of actual is not the same as expected").isNull();
    }
}