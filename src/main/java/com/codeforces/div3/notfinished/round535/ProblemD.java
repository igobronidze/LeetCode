package com.codeforces.div3.notfinished.round535;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        String s = scanner.next();

        int[][] dp = new int[n][3];

        if (s.charAt(0) == 'R') {
            dp[0][1] = 1;
            dp[0][2] = 1;
        } else if (s.charAt(0) == 'B') {
            dp[0][0] = 1;
            dp[0][2] = 1;
        } else {
            dp[0][0] = 1;
            dp[0][1] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == 'R') {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = Math.min(dp[i - 1][0] + 1, dp[i - 1][2] + 1);
                dp[i][2] = Math.min(dp[i - 1][0] + 1, dp[i - 1][1] + 1);
            } else if (s.charAt(i) == 'B') {
                dp[i][0] = Math.min(dp[i - 1][1] + 1, dp[i - 1][2] + 1);
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = Math.min(dp[i - 1][0] + 1, dp[i - 1][1] + 1);
            } else {
                dp[i][0] = Math.min(dp[i - 1][1] + 1, dp[i - 1][2] + 1);
                dp[i][1] = Math.min(dp[i - 1][0] + 1, dp[i - 1][2] + 1);
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            }

        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        out.println(min);

        StringBuilder sb = new StringBuilder();
        char last = 'x';
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                char c;
                if (j == 0) {
                    c = 'R';
                } else if (j == 1) {
                    c = 'B';
                } else {
                    c = 'G';
                }

                if (dp[i][j] == min && c != last) {
                    if (s.charAt(i) != c) {
                        min--;
                    }
                    sb.append(c);
                    last = c;
                    break;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            out.print(sb.charAt(i));
        }


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
