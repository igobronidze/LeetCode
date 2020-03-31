package com.codeforces.div2.round622;

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
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (x + y < n) {
                out.print(1);
            } else if (y == n && x == n) {
                out.print(n);
            } else {
                out.print(x + y - n + 1);
            }
            out.print(" ");

            int k = x + y - 1;
            if (k < 1) {
                out.println(1);
            } else if (k > n) {
                out.println(n);
            } else {
                out.println(k);
            }
            out.flush();
        }

        out.flush();
    }
}
