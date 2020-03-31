package com.codeforces.div2.round620;

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
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            int dist = y - x;
            if (dist % (a + b) == 0) {
                out.println(dist / (a + b));
            } else {
                out.println(-1);
            }
        }

        out.flush();
    }
}
