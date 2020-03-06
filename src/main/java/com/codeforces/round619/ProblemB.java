package com.codeforces.round619;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
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
            for (int i = 0; i < n; i++) {
                list.add(scanner.nextInt());
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int m = Integer.MIN_VALUE;
            for (int i = 1; i < n - 1; i++) {
                if (list.get(i) != -1 && (list.get(i - 1) == -1 || list.get(i + 1) == -1)) {
                    min = Math.min(min, list.get(i));
                    max = Math.max(max, list.get(i));
                }
            }
            if (list.get(1) == -1 && list.get(0) != -1) {
                min = Math.min(min, list.get(0));
                max = Math.max(max, list.get(0));
            }
            if (list.get(n - 2) == -1 && list.get(n - 1) != -1) {
                min = Math.min(min, list.get(n - 1));
                max = Math.max(max, list.get(n - 1));
            }

            for (int i = 1; i < n; i++) {
                if (list.get(i) != -1 && list.get(i - 1) != -1) {
                    m = Math.max(m, Math.abs(list.get(i) - list.get(i - 1)));
                }
            }

            if (min == Integer.MAX_VALUE) {
                out.println("0 0");
            } else {
                int x = (min + max) / 2;
                int r = Math.max(Math.abs(min - x), Math.abs(max - x));
                out.println(Math.max(r, m) + " " + x);
            }

        }

        out.flush();
    }
}
