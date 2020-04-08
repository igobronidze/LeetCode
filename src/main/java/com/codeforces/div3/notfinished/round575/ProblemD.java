package com.codeforces.div3.notfinished.round575;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String s = scanner.next();

            int ans = Integer.MAX_VALUE;
            int[][] dp = new int[n + 3][3];
            for (int i = 0; i < 3; i++) {
                char c = getChar(i);
                int x = 0;
                for (int j = 0; j < k; j++) {
                    if (s.charAt(j) != c) {
                        x++;
                    }
                    c = getNext(c);
                }
                dp[k - 1][i] = x;
                ans = Math.min(ans, x);
            }
            for (int i = k; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    int ind = (j + 2) % 3;
                    int x = dp[i - 1][ind];
                    if (s.charAt(i - k) != getChar(ind)) {
                        x--;
                    }
                    if (s.charAt(i) != getChar((j + k - 1) % 3)) {
                        x++;
                    }
                    dp[i][j] = x;
                    ans = Math.min(ans, x);
                }
            }
            out.println(ans);
        }



        out.flush();
    }

    private static char getChar(int i) {
        if (i == 0) {
            return 'R';
        }
        if (i == 1) {
            return 'G';
        }
        return 'B';
    }

    private static char getNext(char c) {
        if (c == 'R') {
            return 'G';
        }
        if (c == 'G') {
            return 'B';
        }
        return 'R';
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
