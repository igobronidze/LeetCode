package com.codeforces.div2.round621;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class ProblemB {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();

            int max = Integer.MIN_VALUE;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int w = scanner.nextInt();
                max = Math.max(max, w);
                set.add(w);
            }

            int ans = x / max;

            if (set.contains(x)) {
                out.println(1);
            } else if (ans == 0) {
                out.println(2);
            } else if (x % max == 0) {
                out.println(ans);
            } else {
                out.println(ans + 1);
            }
        }


        out.flush();
    }
}
