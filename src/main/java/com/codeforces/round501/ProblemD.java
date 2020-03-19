package com.codeforces.round501;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long s = scanner.nextLong();

        long max = (long) (n - 1) * k;

        if (max < s || k > s) {
            out.println("NO");
        } else {
            out.println("YES");
            if (s % k == 0) {
                for (int i = 0; i < k; i++) {
                    if (i % 2 == 0) {
                        out.print((s / k + 1) + " ");
                    } else {
                        out.print("1 ");
                    }
                }
            } else {
                long x = s / k + 1;
                long mod = s % k;
                long ind = 1;
                for (int i = 0; i < mod; i++) {
                    if (ind + x <= n) {
                        ind = ind + x;
                    } else {
                        ind = ind - x;
                    }
                    out.print(ind + " ");
                }
                x--;
                for (long i = mod; i < k; i++) {
                    if (ind + x <= n) {
                        ind = ind + x;
                    } else {
                        ind = ind - x;
                    }
                    out.print(ind + " ");
                }
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
}
