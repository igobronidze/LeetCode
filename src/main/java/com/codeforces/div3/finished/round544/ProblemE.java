package com.codeforces.div3.finished.round544;

import java.io.*;
import java.util.*;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            list.add(x);
            if (!map.containsKey(x)) {
                map.put(x, 0);
            }
            map.put(x, map.get(x) + 1);
        }
        Collections.sort(list);

        List<Integer> possCount = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = list.get(i); j >= list.get(i) - 5; j--) {
                if (map.containsKey(j)) {
                    c += map.get(j);
                }
            }
            possCount.add(c);
        }


        int[][] dp = new int[n + 5][k + 5];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int c = possCount.get(i);
            int ind = i - c;
            if (ind < 0) {
                dp[i][1] = c;
                ans = Math.max(ans, c);
            } else {
                for (int j = 1; j <= k; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[ind][j - 1] + c);
                    ans = Math.max(ans, dp[i][j]);
                }
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
