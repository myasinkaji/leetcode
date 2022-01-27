package ir.home.tutorial.algorithm.recursive;


import ir.home.tutorial.Timer;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RecursiveTests {


    @Nested
    @IndicativeSentencesGeneration(separator = " -> ", generator = DisplayNameGenerator.IndicativeSentences.class)
    class PracticeOneTests {
        //methodName_stateUnderTest_expectedBehavior
        @ParameterizedTest
        @CsvSource(value = {
                "50, 86267571219, 15, 14, 8",
                "4, 14, 9, 8, 5",
                "5, 26, 15, 14, 8",
        })
        void f_positiveNumber_shouldReturnResult(int n, Long expected, int expectedCalls, int expectedAdds, int expectedMults) {
            //Arrange
            final var recursive = new Recursive();

            //Act
            Timer.newTimer("Practice One").takeTime();
            Long actual = recursive.p1(n);
            Timer.get().finish().printTime();
            //Assertion
            assertEquals(expected, actual);
//            assertEquals(expectedCalls, recursive.p1CallCount);
//            assertEquals(expectedAdds, recursive.p1AddCount);
//            assertEquals(expectedMults, recursive.p1MultCount);
        }

    }


}