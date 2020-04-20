package com.codeforces.div3.notfinished.round634;

import java.io.*;
import java.util.*;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(scanner.nextInt());
            }
            if (n == 1) {
                out.println(n);
            } else {
                int[][] dp = new int[n + 1][202];
                dp[0][list.get(0)] = 1;
                for (int i = 1; i < n; i++) {
                    for (int j = 1; j <= 200; j++) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    dp[i][list.get(i)]++;
                }

                TreeMap<Integer, Integer>[] maps = new TreeMap[205];
                for (int i = 0; i < n; i++) {
                    if (maps[list.get(i)] == null) {
                        maps[list.get(i)] = new TreeMap<>();
                        maps[list.get(i)].put(1, i);
                    } else {
                        maps[list.get(i)].put(maps[list.get(i)].lastKey() + 1, i);
                    }
                }
                int ans = 0;
                int[] count = new int[205];
                for (int i = n - 1; i >= 0; i--) {
                    count[list.get(i)]++;
                    int ind = maps[list.get(i)].get(count[list.get(i)]);
                    if (ind < i) {
                        int max = 0;
                        for (int j = 1; j <= 200; j++) {
                            max = Math.max(max, dp[i - 1][j] - dp[ind][j]);
                        }
                        ans = Math.max(ans, count[list.get(i)] * 2 + max);
                    }
                }

                for (int i = 1; i <= 200; i++) {
                    ans = Math.max(ans, count[i]);
                }

                out.println(ans);
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
