package com.codeforces.div2.notfinished.round618;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 2 * n; i++) {
                list.add(scanner.nextInt());
            }
            Collections.sort(list);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int x = list.get(n) - list.get(i);
                min = Math.min(min, x);
            }
            for (int i = n; i < 2 * n; i++) {
                int x = list.get(i) - list.get(n - 1);
                min = Math.min(min, x);
            }

            out.println(min);
        }

        out.flush();
    }
}
