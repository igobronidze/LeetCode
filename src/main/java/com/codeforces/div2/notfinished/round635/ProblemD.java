package com.codeforces.div2.notfinished.round635;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int r = scanner.nextInt();
            int g = scanner.nextInt();
            int b = scanner.nextInt();
            List<Integer> rList = new ArrayList<>();
            List<Integer> gList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                int x = scanner.nextInt();
                rList.add(x);
            }
            for (int i = 0; i < g; i++) {
                int x = scanner.nextInt();
                gList.add(x);
            }
            for (int i = 0; i < b; i++) {
                int x = scanner.nextInt();
                bList.add(x);
            }
            TreeSet<Integer> rSet = new TreeSet<>(rList);
            TreeSet<Integer> gSet = new TreeSet<>(gList);
            TreeSet<Integer> bSet = new TreeSet<>(bList);
            long ans = Long.MAX_VALUE;
            ans = Math.min(ans, solve(rList, bSet, gSet));
            ans = Math.min(ans, solve(rList, gSet, bSet));
            ans = Math.min(ans, solve(bList, rSet, gSet));
            ans = Math.min(ans, solve(bList, gSet, rSet));
            ans = Math.min(ans, solve(gList, rSet, bSet));
            ans = Math.min(ans, solve(gList, bSet, rSet));

            out.println(ans);
        }




        out.flush();
    }

    private static long solve(List<Integer> list, TreeSet<Integer> set1, TreeSet<Integer> set2) {
        Long ans = Long.MAX_VALUE;
        Integer y = null, u1 = null, u2 = null;
        for (int x : list) {
            y = set1.higher(x - 1);
            if (y != null) {
                int k = (x + y) / 2;
                u1 = set2.higher(k - 1);
                u2 = set2.lower(k + 1);
                if (u1 != null) {
                    ans = Math.min(ans, f(x, y, u1));
                }
                if (u2 != null) {
                    ans = Math.min(ans, f(x, y, u2));
                }
            }
        }
        return ans;
    }

    private static long f(int a, int b, int c) {
        long s = ((long)a - b) * (a - b);
        s += ((long)a - c) * (a - c);
        s += ((long)b - c) * (b - c);
        return s;
    }

    private static class MyScanner {
        private BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        private MyScanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        private String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }

        private String nextLine() {
            String str = "";
            try {
                str = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    private static class Pair<F, S> {

        private F first;

        private S second;

        public Pair() {}

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }

    private static class Triple<F, S, T> {

        private F first;

        private S second;

        private T third;

        public Triple() {}

        public Triple(F first, S second, T third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}
