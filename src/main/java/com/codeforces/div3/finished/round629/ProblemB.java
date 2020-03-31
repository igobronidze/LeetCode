package com.codeforces.div3.finished.round629;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemB {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int r = 0;
            for (int i = 1; i <= n; i++) {
                if ((long) i * (i - 1) / 2 >= k) {
                    r = i;
                    break;
                }
            }
            char[] str = new char[n + 1];

            for (int i = 0; i < n; i++) {
                str[i] = 'a';
            }
            str[n - r] = 'b';

            int x = k - (int) ((long) (r - 1) * (r - 2) / 2);
            str[n - x] = 'b';

            for (int i = 0; i < n; i++) {
                out.print(str[i]);
            }

            out.println();
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

        public Pair() {}

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
