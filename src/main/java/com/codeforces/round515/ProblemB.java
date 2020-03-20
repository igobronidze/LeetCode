package com.codeforces.round515;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemB {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int r = scanner.nextInt();
        boolean[] house = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            house[i] = (x == 1);
        }

        int x = 0;
        int y = Math.min(n - 1, r - 1);
        int ans = 0;
        while (true) {
            boolean can = false;
            boolean finished = false;
            for (int i = y; i >= x; i--) {
                if (house[i]) {
                    can = true;
                    ans++;
                    if (i + r >= n) {
                        out.println(ans);
                        finished = true;
                        break;
                    }
                    x = i + 1;
                    y = Math.min(n - 1, i + 2 * r - 1);
                }
            }
            if (!can) {
                out.println(-1);
                break;
            }
            if (finished) {
                break;
            }
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
