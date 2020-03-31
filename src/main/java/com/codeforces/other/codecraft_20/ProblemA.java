package com.codeforces.other.codecraft_20;

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
            int m = scanner.nextInt();
            int s = 0;

            for (int i = 0; i < n; i++) {
                s += scanner.nextInt();
            }
            out.println(Math.min(s, m));
        }

        out.flush();
    }
}
