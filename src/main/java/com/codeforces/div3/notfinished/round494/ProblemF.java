package com.codeforces.div3.notfinished.round494;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine());
        }

        int[][] sizes = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int s = 0;
                for (int k = i; k <= j; k++) {
                    s += list.get(k).length();
                }
                sizes[i][j] = s;
            }
        }
        boolean[][] equals = new boolean[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (list.get(i).equals(list.get(j))) {
                    equals[i][j] = true;
                }
            }
        }


        int ans = 0;
        for (int size = 1; size <= n / 2; size++) {
            for (int i = size - 1; i < n; i++) {
                for (int j = i + size; j < n; j++) {
                    boolean equal = true;
                    for (int k = 0; k < size; k++) {
                        if (!equals[i - k][j - k]) {
                            equal = false;
                            break;
                        }
                    }
                    if (equal) {
                        ans = Math.max(ans, (sizes[i][i + size - 1] - size + size - 1) * 2);
                    }
                }
            }
        }

        out.println(sizes[0][n - 1] + (n - 1) - ans);



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
