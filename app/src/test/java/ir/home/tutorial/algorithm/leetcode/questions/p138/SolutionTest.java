package ir.home.tutorial.algorithm.leetcode.questions.p138;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {
    private static Solution solution;

    static Stream<Arguments> questionSampleArrays() {
        return Stream.of(
                arguments(linkedList(map(7, null, 13, 0, 11, 4, 10, 2, 1, 0)), linkedList(map(7, null, 13, 0, 11, 4, 10, 2, 1, 0))),
                arguments(linkedList(map(1, 4, 2, 4, 3, 4, 4, 4, 5, 4)), linkedList(map(1, 4, 2, 4, 3, 4, 4, 4, 5, 4))),
                arguments(linkedList(map(1, null, 2, null, 3, null, 4, null, 5, null)), linkedList(map(1, null, 2, null, 3, null, 4, null, 5, null))),
                arguments(null, null)
        );
    }

    private static Map<Integer, Integer> map(Integer... i) {
        final var map = new LinkedHashMap<Integer, Integer>();
        for (int j = 0; j < i.length; j += 2)
            map.put(i[j], i[j + 1]);

        return map;
    }

    private static Node linkedList(Map<Integer, Integer> n) {
        var it = n.keySet().iterator();
        final var head = new Node(it.next());
        var tail = head;
        final var map = new HashMap<Integer, Node>();
        map.put(0, head);
        for (int i = 1; it.hasNext(); i++) {
            tail.next = new Node(it.next());
            tail = tail.next;
            map.put(i, tail);
        }
        it = n.values().iterator();
        tail = head;
        tail.random = map.get(it.next());
        for (int i = 0; it.hasNext(); i++) {
            tail = tail.next;
            tail.random = map.get(it.next());
        }

        return head;
    }


    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("questionSampleArrays")
    void testQuestionSampleArrays(final Node head) {
        final var actual = solution.copyRandomList(head);
        var actualTail = actual;
        var expectedTail = head;
        for (; expectedTail != null; actualTail = actualTail.next, expectedTail = expectedTail.next) {
            if (actualTail == expectedTail || actualTail.val != expectedTail.val || (expectedTail.random != null && expectedTail.random.val != actualTail.random.val)) {
                final var actualList = new StringBuilder();
                final var expectedList = new StringBuilder();
                for (actualTail = actual; actualTail != null; actualTail = actualTail.next)
                    actualList.append(actualTail.val).append(", ");

                for (expectedTail = head; expectedTail != null; expectedTail = expectedTail.next)
                    expectedList.append(expectedTail.val).append(", ");

                fail("actual: %s\nexpected to be: %s", actualList.toString(), expectedList.toString());
            }
        }

        assertThat(actualTail).overridingErrorMessage("length of actual is not the same as expected").isNull();
    }
}