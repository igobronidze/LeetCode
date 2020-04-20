package com.codeforces.div3.notfinished.round496;

import java.io.*;
import java.util.*;

public class ProblemE_1 {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        int ind = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            list.add(x);
            if (x == m) {
                ind = i;
            }
        }

        int[] dp = new int[n];
        if (list.get(0) <= m) {
            dp[0] = 1;
        } else {
            dp[0] = -1;
        }
        for (int i = 1; i < n; i++) {
            if (list.get(i) <= m) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1] - 1;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = ind; i < n; i++) {
            int x = dp[i];
            if (!map.containsKey(x)) {
                map.put(x, 0);
            }
            map.put(x, map.get(x) + 1);
        }

        long ans = 0;

        for (int i = 0; i <= ind; i++) {
            int x = 0;
            if (i != 0) {
                x = dp[i - 1];
            }
            if (map.containsKey(x)) {
                ans += map.get(x);
            }
            if (map.containsKey(x + 1)) {
                ans += map.get(x + 1);
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
