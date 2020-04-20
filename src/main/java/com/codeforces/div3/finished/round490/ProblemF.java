package com.codeforces.div3.finished.round490;

import java.io.*;
import java.util.*;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Map<Integer, Integer> cards = new HashMap<>();
        for (int i = 0; i < n * k; i++) {
            int x = scanner.nextInt();
            if (!cards.containsKey(x)) {
                cards.put(x, 0);
            }
            cards.put(x, cards.get(x) + 1);
        }
        Map<Integer, Integer> favorites = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (!favorites.containsKey(x)) {
                favorites.put(x, 0);
            }
            favorites.put(x, favorites.get(x) + 1);
        }

        List<Integer> h = new ArrayList<>();
        h.add(0);
        for (int i = 0; i < k; i++) {
            h.add(scanner.nextInt());
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : cards.entrySet()) {
            int c = entry.getValue();
            if (favorites.containsKey(entry.getKey())) {
                int m = favorites.get(entry.getKey());
                int[][] dp = new int[m + 1][c + 1];
                dp[0][1] = h.get(1);
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j <= c; j++) {
                        for (int p = 0; p <= Math.min(j, k); p++) {
                            dp[i][j] = Math.max(dp[i][j], (i == 0 ? 0 : dp[i - 1][j - p]) + h.get(p));
                        }
                    }
                }
                ans += dp[m - 1][c];
            }
        }

        out.println(ans);





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
