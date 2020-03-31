package com.codeforces.div2.round602;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProblemA {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            int min = Integer.MAX_VALUE;
            int max = -1;

            for (int i = 0; i < n; i++) {
                max = Math.max(max, scanner.nextInt());
                min = Math.min(min, scanner.nextInt());
            }

            int ans = max - min;
            if (ans < 0) {
                out.println(0);
            } else {
                out.println(ans);
            }
        }

        out.flush();
    }
}
