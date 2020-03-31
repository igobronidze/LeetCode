package com.codeforces.other.ozon_tech_challenge_2020;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        if (m == 0) {
            for (int i = n; i < n * 2; i++) {
                out.print(i + " ");
            }
        } else {
            if (n < 3) {
                out.println(-1);
            } else {
                List<Integer> ans = new ArrayList<>();
                ans.add(1);
                ans.add(2);
                for (int i = 3; i <= n; i++) {
                    if (i / 2 > m) {
                        if (m != 0) {
                            ans.add(i + i - 2 * m - 1);
                            m = 0;
                        } else {
                            for (int j = i; j <= n; j++) {
                                ans.add(100000000 + j * 10000 + 1);
                            }
                            break;
                        }
                    } else {
                       ans.add(i);
                       m -= (i - 1) / 2;
                    }
                }
                if (m != 0) {
                    out.println(-1);
                } else {
                    for (int x : ans) {
                        out.print(x + " ");
                    }
                }
            }
        }

        out.flush();
    }
}
