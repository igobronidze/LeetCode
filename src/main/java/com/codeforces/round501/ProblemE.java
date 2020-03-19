package com.codeforces.round501;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        boolean[][] grid = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                if (c == '*') {
                    grid[i][j] = true;
                }
            }
        }


        int[][] top = new int[n][m];
        int[][] left = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    if (i == 0) {
                        top[i][j] = 1;
                    } else {
                        top[i][j] = top[i - 1][j] + 1;
                    }
                    if (j == 0) {
                        left[i][j] = 1;
                    } else {
                        left[i][j] = left[i][j - 1] + 1;
                    }
                }
            }
        }

        int[][] bottom = new int[n][m];
        int[][] right = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (grid[i][j]) {
                    if (i == n - 1) {
                        bottom[i][j] = 1;
                    } else {
                        bottom[i][j] = bottom[i + 1][j] + 1;
                    }
                    if (j == m - 1) {
                        right[i][j] = 1;
                    } else {
                        right[i][j] = right[i][j + 1] + 1;
                    }
                }
            }
        }

        int[][] stars = new int[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int length = Math.min(top[i][j], bottom[i][j]);
                length = Math.min(length, left[i][j]);
                length = Math.min(length, right[i][j]);
                if (length > 1) {
                    stars[i][j] = length - 1;
                    count++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int x = 0;
            for (int j = 0; j < m; j++) {
                if (x != 0) {
                    x--;
                    grid[i][j] = false;
                }
                if (stars[i][j] != 0) {
                    x = Math.max(x, stars[i][j]);
                    grid[i][j] = false;
                }
            }
            x = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (x != 0) {
                    x--;
                    grid[i][j] = false;
                }
                if (stars[i][j] != 0) {
                    x = Math.max(x, stars[i][j]);
                    grid[i][j] = false;
                }
            }
        }

        for (int j = 0; j < m; j++) {
            int x = 0;
            for (int i = 0; i < n; i++) {
                if (x != 0) {
                    x--;
                    grid[i][j] = false;
                }
                if (stars[i][j] != 0) {
                    x = Math.max(x, stars[i][j]);
                    grid[i][j] = false;
                }
            }
            x = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (x != 0) {
                    x--;
                    grid[i][j] = false;
                }
                if (stars[i][j] != 0) {
                    x = Math.max(x, stars[i][j]);
                    grid[i][j] = false;
                }
            }
        }



        boolean cant = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    cant = true;
                }
            }
        }

        if (cant) {
            out.println(-1);
        } else {
            out.println(count);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (stars[i][j] != 0) {
                        out.println((i + 1) + " " + (j + 1) + " " + stars[i][j]);
                    }
                }
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

        public Pair() {
        }

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
