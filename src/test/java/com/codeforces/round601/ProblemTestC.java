package com.codeforces.round601;

import com.codeforces.ProblemTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProblemTestC extends ProblemTest {

    @BeforeClass
    public static void init() {
        cases.put("5\n" +
                "4 3 2\n" +
                "2 3 5\n" +
                "4 1 2\n", "1 4 2 3 5 ");
    }

    @Test
    public void testCases() {
        testCases(ProblemC.class);
    }
}
