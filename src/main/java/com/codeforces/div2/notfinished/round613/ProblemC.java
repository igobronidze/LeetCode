package com.codeforces.div2.notfinished.round613;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        long x = scanner.nextLong();

        long min = x;
        long a = x, b = x;
        for (int i = 1; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                long p = i;
                long q = x / i;
                if (getLCM(p, q) == x) {
                    if (min > Math.max(p, q)) {
                        min = Math.max(p, q);
                        a = p;
                        b = q;
                    }
                }
            }
        }

        out.println(a + " " + b);

        out.flush();
    }

    private static long getLCM(long x, long y) {
        long a = x, b = y;
        while (y != 0) {
            long p = y;
            y = x % y;
            x = p;
        }
        return a / x * b;
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
}
