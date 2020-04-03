package com.codeforces.div2.notfinished.round623;

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
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int p = scanner.nextInt();
            String s = scanner.next();
            long sum = s.charAt(0) == 'A' ? a : b;
            for (int i = 2; i < s.length(); i++) {
                if (s.charAt(i - 2) != s.charAt(i - 1)) {
                   sum += (s.charAt(i - 1) == 'A' ? a : b);
                }
            }

            long x = 0;
            if (sum <= p) {
                out.println(1);
            } else {
                boolean solved = false;
                for (int i = 1; i < s.length(); i++) {
                    if (s.charAt(i) != s.charAt(i - 1)) {
                        x += s.charAt(i - 1) == 'A' ?  a : b;
                    }
                    if (sum - x <= p) {
                        out.println(i + 1);
                        solved = true;
                        break;
                    }
                }
                if (!solved) {
                    out.println(s.length());
                }
            }

        }

        out.flush();
    }
}
