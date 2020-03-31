package com.codeforces.other.codecraft_20;

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
            String s = scanner.next();

            String minS = s;
            int ansK = 1;

            for (int k = 2; k <= n; k++) {
                String str = s.substring(k - 1, n) + ((k + n) % 2 == 1 ? s.substring(0, k - 1) : reverse(s.substring(0, k - 1)));
                if (minS.compareTo(str) > 0) {
                    ansK = k;
                    minS = str;
                }
            }

            out.println(minS);
            out.println(ansK);
        }

        out.flush();
    }

    private static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
