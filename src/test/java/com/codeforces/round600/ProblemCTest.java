package com.codeforces.round600;

import com.codeforces.ProblemTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

public class ProblemCTest extends ProblemTest {

    @BeforeClass
    public static void init() {
        cases.put("9 2\n" +
                "6 19 3 4 4 2 6 7 8", "2 5 11 18 30 43 62 83 121");
        cases.put("1 1\n" +
                "7", "7");
    }

    @Test
    public void testCases() {
        for (Map.Entry<String, String> entry : cases.entrySet()) {
            testCase(ProblemC.class, entry.getKey(), entry.getValue());
        }
    }
}
