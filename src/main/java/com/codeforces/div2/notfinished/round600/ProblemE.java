package com.codeforces.div2.notfinished.round600;

import java.io.*;
import java.util.*;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair<>(scanner.nextInt(), scanner.nextInt()));
        }
        list.sort(Comparator.comparingInt(t -> t.first));

        int[][] dp = new int[n][m + 1];

        for (int i = 0; i < n; i++) {
            for (int k = 1; k <= m; k++) {
                Pair<Integer, Integer> pair = list.get(i);
                int a = pair.first - 1 - pair.second;
                int b = k - pair.first - pair.second;
                int x = Math.max(a, b);
                x = Math.max(0, x);
                dp[i][k] = x;

                if (i != 0) {
                    dp[i][k] = Math.min(dp[i - 1][k], dp[i][k]);
                    x = Math.max(0, k - pair.first - pair.second);
                    int pk = pair.first - pair.second - x;
                        if (pk > 0) {
                            dp[i][k] = Math.min(dp[i][k], dp[i - 1][pk - 1] + x);
                        }
                }
            }
        }

        out.println(dp[n - 1][m]);

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
