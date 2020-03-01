package com.codeforces.round625;

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

        int n = scanner.nextInt();

        int[] r = new int[n + 1];
        int[] b = new int[n + 1];

        for (int i = 0; i < n; i++) {
            r[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if (r[i] == 1 && b[i] == 0) {
                x++;
            }
            if (r[i] == 0 && b[i] == 1) {
                y++;
            }
        }
        if (x == 0) {
            out.println(-1);
        } else {
            y++;

            int ans = y / x;
            if (y % x == 0) {
                out.println(ans);
            } else {
                out.println(ans + 1);
            }
        }


        out.flush();
    }
}
