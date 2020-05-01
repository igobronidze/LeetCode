package com.codeforces.div3.finished.round570;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemH {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        long m = 1_000_000_000_000L;
        int n = scanner.nextInt();
        long k = scanner.nextLong();
        String s = scanner.next();
        int[][] lst = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                lst[i][j] = -1;
                for (int p = 0; p <= i; p++) {
                    if (s.charAt(p) == (char)(j + 'a')) {
                        lst[i][j] = p;
                    }
                }
            }
        }

        long[][] dp = new long[n][n + 1];
        for (int i = 0; i < n; i++) {
            dp[i][1] = 1;
        }

        for (int size = 2; size <= n; size++) {
            for (int i = size - 1; i < n; i++) {
                for (int p = 0; p < 26; p++) {
                    int lstInd = lst[i - 1][p];
                    if (lstInd != -1) {
                        dp[i][size] += dp[lstInd][size - 1];
                        dp[i][size] = Math.min(dp[i][size], m);
                    }
                }
            }
        }

        long ans = 0;
        for (int size = n; size >= 1; size--) {
            for (int i = 0; i < 26; i++) {
                int lstInd = lst[n - 1][i];
                if (lstInd != -1) {
                    if (k > dp[lstInd][size]) {
                        k -= dp[lstInd][size];
                        ans += (n - size) * dp[lstInd][size];
                    } else {
                        ans += (n - size) * k;
                        k = 0;
                        break;
                    }
                }
            }
            if (k <= 0) {
                break;
            }
        }

        if (k == 1) {
            out.println(ans + n);
        } else if (k <= 0) {
            out.println(ans);
        } else {
            out.println(-1);
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
