package com.codeforces.div2.round622;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
            int c = scanner.nextInt();

            int ans = 0;
            if (a > 0) {
                a--;
                ans++;
            }
            if (b > 0) {
                b--;
                ans++;
            }
            if (c > 0) {
                c--;
                ans++;
            }

            List<Integer> list = Arrays.asList(a, b, c);
            Collections.sort(list);

            if (list.get(2) > 0 && list.get(1) > 0) {
                ans++;
                list.set(2, list.get(2) - 1);
                list.set(1, list.get(1) - 1);
            }
            if (list.get(2) > 0 && list.get(0) > 0) {
                ans++;
                list.set(2, list.get(2) - 1);
                list.set(0, list.get(0) - 1);
            }
            if (list.get(1) > 0 && list.get(0) > 0) {
                ans++;
                list.set(1, list.get(1) - 1);
                list.set(0, list.get(0) - 1);
            }
            if (list.get(2) > 0 && list.get(1) > 0 && list.get(0) > 0) {
                ans++;
            }

            out.println(ans);
        }

        out.flush();
    }
}
