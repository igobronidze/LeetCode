package com.codeforces.round521;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemF1 {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int x = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        if (k * (x + 1) - 1 >= n) {
            long[][][] dp = new long[n][n][x + 1];

            for (int i = 0; i < n ; i++) {
                for (int j = 0; j <= i; j++) {
                    for (int f = 1; f <= Math.min(x, i + 1); f++) {
                        if (j == i) {
                            if (f == 1) {
                                if (i >= k) {
                                    dp[i][j][f] = 0;
                                } else {
                                    dp[i][j][f] = list.get(i);
                                }
                            } else {
                                long max = 0;
                                for (int q = Math.max(0, i - k); q < i; q++) {
                                    max = Math.max(max, dp[q][q][f - 1]);
                                }
                                if (max == 0) {
                                    dp[i][j][f] = 0;
                                } else {
                                    dp[i][j][f] = max + list.get(i);
                                }
                            }
                        } else {
                            if (i - j >= k) {
                                dp[i][j][f] = 0;
                            } else {
                                dp[i][j][f] = dp[j][j][f];
                            }
                        }
                    }
                }
            }


            long ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, dp[n - 1][i][x]);
            }

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
}
