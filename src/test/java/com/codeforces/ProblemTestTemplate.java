package com.codeforces;

import org.junit.BeforeClass;
import org.junit.Test;

public class ProblemTestTemplate extends ProblemTest {

    @BeforeClass
    public static void init() {
        cases.put("", "");
    }

    @Test
    public void testCases() {
        testCases(null);
    }
}
