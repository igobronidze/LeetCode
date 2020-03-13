package com.codeforces.round627;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int h = scanner.nextInt();
        int l = scanner.nextInt();
        int r = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            list.add(scanner.nextInt());
        }

        int[][] dp = new int[n + 1][h + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= h; j++) {
                dp[i][j] = -1;
            }
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            int x = list.get(i - 1);
            for (int j = 0; j < h; j++) {
                if (dp[i - 1][j] != -1) {
                    int jh = (j + x) % h;
                    if (jh >= l && jh <= r) {
                        dp[i][jh] = Math.max(dp[i][jh], dp[i - 1][j] + 1);
                    } else {
                        dp[i][jh] = Math.max(dp[i][jh], dp[i - 1][j]);
                    }

                    jh = (j + x - 1) % h;
                    if (jh >= l && jh <= r) {
                        dp[i][jh] = Math.max(dp[i][jh], dp[i - 1][j] + 1);
                    } else {
                        dp[i][jh] = Math.max(dp[i][jh], dp[i - 1][j]);
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < h; i++) {
            ans = Math.max(ans, dp[n][i]);
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
}
