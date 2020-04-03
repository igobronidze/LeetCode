package com.codeforces.div2.notfinished.round601;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProblemB {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int k = 0; k < t; k++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += scanner.nextInt();
            }

            if (m < 3 || m != n) {
                out.println(-1);
                continue;
            }

            out.println(sum * 2);
            for (int i = 1; i < m; i++) {
                out.println(i + " " + (i + 1));
            }
            out.println(m + " " + 1);
        }

        out.flush();
    }
}
