package com.codeforces.div2.notfinished.round602;

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

            int[] arr = new int[n + 1];
            List<Integer> ans = new ArrayList<>();
            int max = 0;
            int index = 1;

            boolean cant = false;
            for (int i = 0; i < list.size(); i++) {
                int x = list.get(i);
                if (x < i + 1) {
                    out.println(-1);
                    cant = true;
                    break;
                }
                if (x > max) {
                    ans.add(x);
                    arr[x] = 1;
                    max = x;
                } else {
                    while (arr[index] == 1) {
                        index++;
                    }
                    ans.add(index);
                    arr[index] = 1;
                }
            }

            if (!cant) {
                printList(ans, out);
            }

        }


        out.flush();
    }

    private static void printList(List<Integer> list, PrintWriter out) {
        for (int x : list) {
            out.print(x + " ");
        }
        out.println();
    }
}
