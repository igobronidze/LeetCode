package com.codeforces.round623;

import com.codeforces.ProblemTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProblemTestA extends ProblemTest {

    @BeforeClass
    public static void init() {
        cases.put("6\n" +
                "8 8 0 0\n" +
                "1 10 0 3\n" +
                "17 31 10 4\n" +
                "2 1 0 0\n" +
                "5 10 3 9\n" +
                "10 10 4 8", "56\n" +
                "6\n" +
                "442\n" +
                "1\n" +
                "45\n" +
                "80");
    }

    @Test
    public void testCases() {
        testCases(ProblemA.class);
    }
}
