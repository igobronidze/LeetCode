package com.codeforces.ozon_tech_challenge_2020;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
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
            int n = scanner.nextInt();
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a.add(scanner.nextInt());
            }
            for (int i = 0; i < n; i++) {
                b.add(scanner.nextInt());
            }
            Collections.sort(a);
            Collections.sort(b);
            for (int x : a) {
                out.print(x + " ");
            }
            out.println();
            for (int x : b) {
                out.print(x + " ");
            }
            out.println();
        }

        out.flush();
    }
}
