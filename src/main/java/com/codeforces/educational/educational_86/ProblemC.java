package com.codeforces.educational.educational_86;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int q = scanner.nextInt();

            long[] dp = new long[a * b + 1];
            long s = 0;
            for (int j = 0; j < a * b; j++) {
                if (j % a % b != j % b % a) {
                    s++;
                }
                dp[j] = s;
            }

            for (int i = 0; i < q; i++) {
                long l = scanner.nextLong();
                long r = scanner.nextLong();
                int x = (int) (l % (a * b));
                int y = (int) (r % (a * b));

                long ans = s * ((r - l) / (a * b));
                if (x <= y) {
                    ans = ans + dp[y] - (x == 0 ? 0 : dp[x - 1]);
                } else {
                    ans = ans + dp[y] - (x == 0 ? 0 : dp[x- 1]) + s;
                }
                out.print(ans + " ");
            }
            out.println();
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
