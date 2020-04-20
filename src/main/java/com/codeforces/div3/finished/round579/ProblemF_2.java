package com.codeforces.div3.finished.round579;

import java.io.*;
import java.util.*;

public class ProblemF_2 {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int r = scanner.nextInt();

        List<Pair<Integer, Integer>> positives = new ArrayList<>();
        List<Pair<Integer, Integer>> negatives = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (y >= 0) {
                positives.add(new Pair<>(x, y));
            } else {
                negatives.add(new Pair<>(x, y));
            }
        }

        Collections.sort(positives, Comparator.comparingInt(x -> x.first));
        int ans = 0;
        for (Pair<Integer, Integer> pair : positives) {
            if (pair.first > r) {
                break;
            } else {
                ans++;
                r = r + pair.second;
            }
        }

        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < negatives.size(); i++) {
            list.add(new Pair<>(negatives.get(i).first + negatives.get(i).second, i));
        }
        Collections.sort(list, Comparator.comparingInt(x -> x.first));
        Collections.reverse(list);

        int[][] dp = new int[n + 1][r + 1];

        int max = 0;
        for (int i = 0; i < negatives.size(); i++) {
            int ind = list.get(i).second;
            for (int j = 0; j <= r; j++) {
                if (i != 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                if (j - negatives.get(ind).second <= r && j - negatives.get(ind).second >= negatives.get(ind).first) {
                    int x = 0;
                    if (i != 0) {
                        x = dp[i - 1][j - negatives.get(ind).second];
                    }
                    dp[i][j] = Math.max(dp[i][j], x + 1);
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        out.println(ans + max);




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
