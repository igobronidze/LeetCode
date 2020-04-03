package com.codeforces.div2.notfinished.round623;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();

            List<Integer> list = new ArrayList<>();
            List<Integer> ans = new ArrayList<>();
            List<Integer> aList = getAList(n);
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                list.add(x);
                aList.remove(new Integer(x));
            }

            boolean cant = false;
            for (int i = 0; i < n; i++) {
                int x = list.get(i);
                int y = getSmallest(x, aList);
                if (y == -1) {
                    out.println(-1);
                    cant = true;
                    break;
                }
                ans.add(x);
                ans.add(y);
            }

            if (!cant) {
                for (int x : ans) {
                    out.print(x + " ");
                }
                out.println();
            }
            out.flush();
        }

        out.flush();
    }

    private static int getSmallest(int x, List<Integer> list) {
        for (int a : list) {
            if (a > x) {
                list.remove(new Integer(a));
                return a;
            }
        }
        return -1;
    }

    private static List<Integer> getAList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 2 * n; i++) {
            list.add(i);
        }
        return list;
    }
}
