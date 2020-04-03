package com.codeforces.div2.notfinished.round630;

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
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String s = scanner.next();

            int[][] m = new int[k + 1][30];
            for (int i = 0; i < (k + 1) / 2; i++) {
                int x = i;
                int y = k - i - 1;
                while (x < n) {
                    m[i][s.charAt(x) - 'a']++;
                    m[i][s.charAt(y) - 'a']++;
                    x = x + k;
                    y = y + k;
                }
            }
            int ans = 0;
            for (int i = 0; i < (k + 1) / 2; i++) {
                int max = 0;
                for (int j = 0; j <= 'z' - 'a'; j++) {
                    max = Math.max(max, m[i][j]);
                }
                if (k % 2 == 1 && i == (k + 1) / 2 - 1) {
                    ans += ((n / k) * 2 - max) / 2;
                } else {
                    ans += ((n / k) * 2 - max);
                }
            }
            out.println(ans);
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
}
