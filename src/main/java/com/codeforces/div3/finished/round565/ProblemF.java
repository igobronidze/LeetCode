package com.codeforces.div3.finished.round565;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();

        long[] dp = new long[10];
        for (int i = 1; i < 10; i++) {
            dp[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();
            List<Long> ones = new ArrayList<>();
            long two = 0;
            long three = 0;
            for (int j = 0; j < k; j++) {
                int c = scanner.nextInt();
                long d = scanner.nextLong();
                if (c == 1) {
                    ones.add(d);
                } else if (c == 2) {
                    two = Math.max(two, d);
                } else {
                    three = Math.max(three, d);
                }
            }
            Collections.sort(ones);
            Collections.reverse(ones);

            long[] tmpDP = new long[10];
            System.arraycopy(dp, 0, tmpDP, 0, 10);

            for (int j = 0; j < 10; j++) {
                if (dp[j] >= 0) {
                    if (three != 0) {
                        int index = (j + 1) % 10;
                        tmpDP[index] = Math.max(tmpDP[index], dp[j] + three * (j == 9 ? 2 : 1));
                    }

                    if (two != 0) {
                        int index = (j + 1) % 10;
                        tmpDP[index] = Math.max(tmpDP[index], dp[j] + two * (j == 9 ? 2 : 1));

                        if (!ones.isEmpty()) {
                            index = (j + 2) % 10;
                            tmpDP[index] = Math.max(tmpDP[index], dp[j] + Math.max(ones.get(0), two) * (j >= 8 ? 2 : 1) + Math.min(ones.get(0), two));
                        }
                    }

                    if (ones.size() >= 1) {
                        int index = (j + 1) % 10;
                        tmpDP[index] = Math.max(tmpDP[index], dp[j] + ones.get(0) * (j == 9 ? 2 : 1));
                    }
                    if (ones.size() >= 2) {
                        int index = (j + 2) % 10;
                        tmpDP[index] = Math.max(tmpDP[index], dp[j] + ones.get(0) * (j >= 8 ? 2 : 1) + ones.get(1));
                    }
                    if (ones.size() >= 3) {
                        int index = (j + 3) % 10;
                        tmpDP[index] = Math.max(tmpDP[index], dp[j] + ones.get(0) * (j >= 7 ? 2 : 1) + ones.get(1) + ones.get(2));
                    }
                }
            }

            System.arraycopy(tmpDP, 0, dp, 0, 10);
        }

        long max = 0;
        for (int i = 0; i < 10; i++) {
            max = Math.max(max, dp[i]);
        }

        out.println(max);


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
