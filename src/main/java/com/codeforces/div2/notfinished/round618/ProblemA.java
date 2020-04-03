package com.codeforces.div2.notfinished.round618;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
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
            List<Integer> list = new ArrayList<>();
            int count = 0;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                list.add(scanner.nextInt());
                if (list.get(list.size() - 1) == 0) {
                    count++;
                    sum++;
                } else {
                    sum += list.get(list.size() - 1);
                }
            }
            if (sum == 0) {
                out.println(count + 1);
            } else {
                out.println(count);
            }
        }


        out.flush();
    }
}
