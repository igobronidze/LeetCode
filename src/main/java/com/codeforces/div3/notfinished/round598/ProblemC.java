package com.codeforces.div3.notfinished.round598;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int d = scanner.nextInt();
        d--;
        List<Integer> list = new ArrayList<>();
        int s = 0;
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            list.add(x);
            s += x;
        }


        if (s + (m + 1) * d < n) {
            out.println("NO");
        } else {
            out.println("YES");
            List<Integer> jumps = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int x = Math.min(d, n - s);
                jumps.add(x);
                n = n - x - list.get(i);
                s = s - list.get(i);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < jumps.get(i); j++) {
                    out.print("0 ");
                }
                for (int j = 0; j < list.get(i); j++) {
                    out.print((i + 1) + " ");
                }
            }
            for (int j = 0; j < n; j++) {
                out.print("0 ");
            }
        }


        out.flush();
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

        public Pair() {
        }

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }

    private static class Triple<F, S, T> {

        private F first;

        private S second;

        private T third;

        public Triple() {
        }

        public Triple(F first, S second, T third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}
