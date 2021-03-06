package com.codeforces.div2.notfinished.round632;

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
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] ans = new char[n][m];
            if (n % 2 == 0) {
                for (int i = 0; i < n; i += 2) {
                    for (int j = 0; j < m; j++) {
                        ans[i][j] = 'W';
                    }
                    for (int j = 0; j < m; j++) {
                        ans[i + 1][j] = 'B';
                    }
                }
                ans[n - 2][m - 1] = 'B';
            } else if (m % 2 == 0) {
                for (int i = 0; i < m; i += 2) {
                    for (int j = 0; j < n; j++) {
                        ans[j][i] = 'W';
                    }
                    for (int j = 0; j < n; j++) {
                        ans[j][i + 1] = 'B';
                    }
                }
                ans[n - 1][m - 2] = 'B';
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if ((i + j) % 2 == 0) {
                            ans[i][j] = 'B';
                        } else {
                            ans[i][j] = 'W';
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    out.print(ans[i][j]);
                }
                out.println();
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
