package com.codeforces.round605;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemA {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            long z = scanner.nextLong();

            long ans = Long.MAX_VALUE;
            for (long i = x - 1; i <= x + 1; i++) {
                for (long j = y - 1; j <= y + 1; j++) {
                    for (long k = z - 1; k <= z + 1; k++) {
                        ans = Math.min(ans, getAns(i, j, k));
                    }
                }
            }

            out.println(ans);
        }

        out.flush();
    }

    private static long getAns(long x, long y, long z) {
        return Math.abs(x - y) + Math.abs(x - z) + Math.abs(y - z);
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
