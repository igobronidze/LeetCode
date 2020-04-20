package com.codeforces.div3.finished.round498;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    private static int n, m;
    private static long[][] mat;
    private static long k;

    private static long ans = 0;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextLong();
        mat = new long[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scanner.nextLong();
            }
        }

        Map<Long, Integer>[][] maps = new HashMap[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maps[i][j] = new HashMap<>();
            }
        }

        dfsLeftTop(0, 0, 0L, maps);
        dfsRightBottom(n - 1, m - 1, 0L, maps);

        out.println(ans);




        out.flush();
    }

    private static void dfsRightBottom(int i, int j, long xor, Map<Long, Integer>[][] maps) {
        if (i < 0 || j < 0) {
            return;
        }
        if (i + j == (n + m) / 2 - 1) {
            if (maps[i][j].containsKey(xor ^ k)) {
                ans += maps[i][j].get(xor ^ k);
            }
            return;
        }
        xor = xor ^ mat[i][j];
        dfsRightBottom(i - 1, j, xor, maps);
        dfsRightBottom(i, j - 1, xor, maps);
    }

    private static void dfsLeftTop(int i, int j, long xor, Map<Long, Integer>[][] maps) {
        if (i >= n || j >= m) {
            return;
        }
        xor = xor ^ mat[i][j];
        if (i + j == (n + m) / 2 - 1) {
            if (!maps[i][j].containsKey(xor)) {
                maps[i][j].put(xor, 0);
            }
            maps[i][j].put(xor, maps[i][j].get(xor) + 1);
            return;
        }
        dfsLeftTop(i + 1, j, xor, maps);
        dfsLeftTop(i, j + 1, xor, maps);
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
