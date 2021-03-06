package com.codeforces.div2.notfinished.round614;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int q = scanner.nextInt();
        boolean[][] grid = new boolean[n][2];

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < q; i++) {
            int y = scanner.nextInt();
            y--;
            int x = scanner.nextInt();
            x--;
            grid[x][y] = !grid[x][y];
            if (x != 0) {
                if ((!grid[x - 1][0] && !grid[x][0]) || (!grid[x - 1][1] && !grid[x][1])) {
                    set.remove(x);
                } else {
                    set.add(x);
                }
            }
            if (x != n - 1) {
                if ((!grid[x + 1][0] && !grid[x][0]) || (!grid[x + 1][1] && !grid[x][1])) {
                    set.remove(x + 1);
                } else {
                    set.add(x + 1);
                }
            }

            if (set.isEmpty()) {
                out.println("Yes");
            } else {
                out.println("No");
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
