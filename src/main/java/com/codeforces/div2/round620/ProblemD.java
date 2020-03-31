package com.codeforces.div2.round620;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            String s = scanner.next();

            List<Integer> ans = new ArrayList<>();
            int count = 1;
            int x = n;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '>') {
                    count++;
                } else {
                    for (int j = x - count + 1; j <= x; j++) {
                        ans.add(j);
                    }
                    x = x - count;
                    count = 0;
                    ans.add(0);
                }
            }
            if (count != 0) {
                for (int j = x - count + 1; j <= x; j++) {
                    ans.add(j);
                }
            }
            int k = 1;
            for (int i = n - 1; i >= 0; i--) {
                if (ans.get(i) == 0) {
                    ans.set(i, k++);
                }
            }

            for (int a : ans) {
                out.print(a + " ");
            }
            out.println();
        }

        out.flush();
    }
}
