package com.codeforces.div3.finished.round552;

import java.io.*;
import java.util.*;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        Collections.sort(list);
        list = list.subList(0, k);
        n = k;

        Map<Integer, Integer> sales = new HashMap<>();
        for (int i = 1; i <= k; i++) {
            sales.put(i, 0);
        }
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (x <= k) {
                sales.put(x, Math.max(sales.get(x), y));
            }
        }

        long[] sum = new long[k + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + list.get(i - 1);
        }

        long[] dp = new long[k + 1];
        for (int i = 0; i < n; i++) {
            int ind = sales.get(i + 1);
            dp[i] = sum[i + 1] - sum[ind];
            for (int j = 0; j < i; j++) {
                ind = sales.get(i - j) + j + 1;
                dp[i] = Math.min(dp[i], dp[j] + sum[i + 1] - sum[ind]);
            }
        }

        out.println(dp[k - 1]);



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
