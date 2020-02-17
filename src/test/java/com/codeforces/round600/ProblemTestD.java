package com.codeforces.round600;

import com.codeforces.ProblemTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProblemTestD extends ProblemTest {

    @BeforeClass
    public static void init() {
        cases.put("14 8\n" +
                "1 2\n" +
                "2 7\n" +
                "3 4\n" +
                "6 3\n" +
                "5 7\n" +
                "3 8\n" +
                "6 8\n" +
                "11 12", "1");
        cases.put("200000 3\n" +
                "7 9\n" +
                "9 8\n" +
                "4 5", "0");
        cases.put("3 1\n" +
                "1 3", "1");
    }

    @Test
    public void testCases() {
        testCases(ProblemD.class);
    }
}
