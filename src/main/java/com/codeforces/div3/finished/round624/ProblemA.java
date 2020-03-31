package com.codeforces.div3.finished.round624;

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
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (a == b) {
                out.println(0);
            } else if ((b - a) % 2 == 0 && a >= b) {
                out.println(1);
            } else if ((b - a) % 2 == 0) {
                out.println(2);
            } else if (a >= b) {
                out.println(2);
            } else {
                out.println(1);
            }
        }

        out.flush();
    }
}
