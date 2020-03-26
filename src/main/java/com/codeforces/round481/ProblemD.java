package com.codeforces.round481;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        if (n <= 2) {
            out.println(0);
        } else {
            List<Pair<Integer, Integer>>[][] dp = new ArrayList[n][3];
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    dp[i][j] = new ArrayList<>();
                }
            }
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int x = list.get(0) + i;
                    int y = list.get(1) + j;
                    dp[1][j + 1].add(new Pair<>((y - x), countCost(i, j)));
                }
            }

            for (int k = 2; k < n; k++) {
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int x = list.get(k - 1) + i;
                        int y = list.get(k) + j;
                        int p = y - x;
                        for (Pair<Integer, Integer> pair : dp[k - 1][i + 1]) {
                            if (pair.first == p) {
                                dp[k][j + 1].add(new Pair<>(p, pair.second + (j == 0 ? 0 : 1)));
                            }
                        }
                    }
                }
            }

            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (Pair<Integer, Integer> pair : dp[n - 1][i]) {
                    if (pair.second < ans) {
                        ans = pair.second;
                    }
                }
            }

            if (ans == Integer.MAX_VALUE) {
                out.println(-1);
            } else {
                out.println(ans);
            }
        }


        out.flush();
    }

    private static int countCost(int i, int j) {
        int s = 2;
        if (i == 0) {
            s--;
        }
        if (j == 0) {
            s--;
        }
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
}
