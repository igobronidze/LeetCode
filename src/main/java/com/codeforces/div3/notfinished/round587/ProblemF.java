package com.codeforces.div3.notfinished.round587;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String s = scanner.next();
        long[] dp = new long[n];
        long[] rrr = new long[n];
        dp[0] = 1;
        TreeMap<Long, Integer> map = new TreeMap<>();
        if (s.charAt(0) == '1') {
            map.put(1L, 1);
            rrr[0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                long p = dp[i - 1] + i + 1;
                dp[i] = p;
            } else {
                long p = i - k - 1 >= 0 ? Math.min(dp[i - k - 1], dp[i - 1]) : 0L;
                p = p + i + 1;
                dp[i] = p;
                if (!map.containsKey(p)) {
                    map.put(p, 0);
                }
                map.put(p, map.get(p) + 1);
                rrr[i] = p;
            }

            if (!map.isEmpty()) {
                dp[i] = Math.min(dp[i], map.firstKey());
            }
            int ind = i - k;
            if (ind >= 0) {
                if (s.charAt(ind) == '1') {
                    map.put(rrr[ind], map.get(rrr[ind]) - 1);
                    if (map.get(rrr[ind]) == 0) {
                        map.remove(rrr[ind]);
                    }
                }
            }
        }

        out.println(dp[n - 1]);



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
