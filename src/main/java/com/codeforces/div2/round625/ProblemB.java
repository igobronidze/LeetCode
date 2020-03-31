package com.codeforces.div2.round625;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemB {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        Map<Integer, Long> dp = new HashMap<>();

        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (!dp.containsKey(x - i)) {
                dp.put(x - i, (long) x);
            } else {
                dp.put(x - i, dp.get(x - i) + x);
            }
            max = Math.max(dp.get(x - i), max);
        }

        out.println(max);


        out.flush();
    }
}
