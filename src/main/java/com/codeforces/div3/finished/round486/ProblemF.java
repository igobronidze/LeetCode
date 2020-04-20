package com.codeforces.div3.finished.round486;

import java.io.*;
import java.util.*;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    private static List<Pair<Integer, Integer>> segments = new ArrayList<>();

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int a = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            segments.add(new Pair<>(scanner.nextInt(), scanner.nextInt()));
        }

        Map<Integer, Integer> umbrellas = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int w = scanner.nextInt();
            if (!umbrellas.containsKey(x)) {
                umbrellas.put(x, Integer.MAX_VALUE);
            }
            umbrellas.put(x, Math.min(umbrellas.get(x), w));
        }

        Map<Integer, Integer>[] dp = new HashMap[a + 1];
        for (int i = 0; i <= a; i++) {
            dp[i] = new HashMap<>();
        }

        dp[0].put(0, 0);
        if (umbrellas.containsKey(0)) {
            int w = umbrellas.get(0);
            dp[0].put(w, 0);
        }
        boolean cant = false;
        for (int i = 1; i <= a; i++) {
            int min = Integer.MAX_VALUE;
            int minCurr = Integer.MAX_VALUE;
            if (dp[i - 1].containsKey(0)) {
                min = dp[i - 1].get(0);
            }
            for (int w : dp[i - 1].keySet()) {
                if (w != 0) {
                    min = Math.min(min, dp[i - 1].get(w));
                    dp[i].put(w, dp[i - 1].get(w) + w);
                    minCurr = Math.min(minCurr, dp[i - 1].get(w) + w);
                }
            }
            if (min == Integer.MAX_VALUE) {
                cant = true;
                break;
            }
            if (!isInRain(i)) {
                dp[i].put(0, min);
                minCurr = Math.min(minCurr, min);
            }
            if (umbrellas.containsKey(i)) {
                int x = umbrellas.get(i);
                dp[i].put(x, minCurr);
            }
        }

        if (cant) {
            out.println(-1);
        } else {
            int ans = Integer.MAX_VALUE;
            for (int value : dp[a].values()) {
                ans = Math.min(ans, value);
            }
            if (ans == Integer.MAX_VALUE) {
                out.println(-1);
            } else {
                out.println(ans);
            }
        }


        out.flush();
    }

    private static boolean isInRain(int x) {
        for (Pair<Integer, Integer> segment : segments) {
            if (segment.first < x && segment.second >= x) {
                return true;
            }
        }
        return false;
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