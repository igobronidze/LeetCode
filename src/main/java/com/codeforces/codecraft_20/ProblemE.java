package com.codeforces.codecraft_20;

import java.io.*;
import java.util.*;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int k = scanner.nextInt();

        List<Pair<Integer, Integer>> aList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            aList.add(new Pair<>(scanner.nextInt(), i));
        }
        aList.sort((t1, t2) -> Integer.compare(t2.first, t1.first));
        int[][] sMatrix = new int[n][p];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                sMatrix[i][j] = scanner.nextInt();
            }
        }

        long[][] dp = new long[n][1 << p];
        dp[0][0] = aList.get(0).first;

        for (int i = 0; i < n; i++) {
            for (int mask = 0; mask < (1 << p); mask++) {
                int c = getSelectedCount(mask, p);

                if (i == 0) {
                    if (c == 1) {
                        dp[i][mask] = sMatrix[aList.get(0).second][log2(mask)];
                    }
                } else {
                    if (n - i - 1 < (p - c) || c > i) {
                        dp[i][mask] = 0;
                    } else {
                        long max = Long.MIN_VALUE;
                        for (int j = 0; j < p; j++) {
                            if ((mask & (1 << j)) != 0) {
                                max = Math.max(max, dp[i - 1][mask ^ (1 << j)] + (long) sMatrix[aList.get(i).second][j]);
                            }
                        }
                        if (c + k > i) {
                            max = Math.max(max, dp[i - 1][mask] + (long) aList.get(i).first);
                        } else {
                            max = Math.max(max, dp[i - 1][mask]);
                        }
                        dp[i][mask] = max;
                    }
                }
            }
        }

        long max = dp[n - 1][(1 << p) - 1];

        out.println(max);
        out.flush();
    }

    private static int getSelectedCount(int mask, int p) {
        int count = 0;
        int x = 1;
        for (int i = 0; i < p; i++) {
            if (mask == (mask | x)) {
                count++;
            }
            x *= 2;
        }
        return count;
    }

    private static int log2(int n) {
        for (int i = 0; i < 7; i++) {
            if ((1 << i) == n) {
                return i;
            }
        }
        return 0;
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
