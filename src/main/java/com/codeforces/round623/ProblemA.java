package com.codeforces.round623;

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
            int a = scanner.nextInt(), b = scanner.nextInt();
            int x = scanner.nextInt(), y = scanner.nextInt();

            int max = x * b;
            max = Math.max(max, (a - x - 1) * b);
            max = Math.max(max, y * a);
            max = Math.max(max, (b - y - 1) * a);

            out.println(max);

        }

        out.flush();
    }
}
