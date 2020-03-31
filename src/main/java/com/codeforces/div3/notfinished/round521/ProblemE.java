package com.codeforces.div3.notfinished.round521;

import java.io.*;
import java.util.*;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (!map.containsKey(x)) {
                map.put(x, 0);
            }
            map.put(x, map.get(x) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort((a, b) -> Integer.compare(b, a));
        int max = list.get(0);

        Pair<Integer, Integer>[] dp = new Pair[max + 1];
        int ans = Integer.MIN_VALUE;
        for (int i = max; i >= 1; i--) {
            if (i * 2 <= max) {
                int ind = dp[i * 2].second + 1;
                if (ind < list.size() && list.get(ind) >= i) {
                    dp[i] = new Pair<>(dp[i * 2].first + i, ind);
                } else {
                    dp[i] = new Pair<>(i, 0);
                }
            } else {
                dp[i] = new Pair<>(i, 0);
            }
            ans = Math.max(ans, dp[i].first);
        }

        out.print(ans);


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
