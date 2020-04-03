package com.codeforces.div3.notfinished.round540;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int[] arr = new int[1001];

        for (int i = 0; i < n ; i++) {
            arr[scanner.nextInt()]++;
        }

        int[][] ans = new int[n + 1][n + 1];

        boolean cant = false;
        if (n % 2 == 0) {
            for (int i = 1; i <= 1000; i++) {
                if (arr[i] % 4 != 0) {
                    if (arr[i] % 2 == 0) {

                    }
                }
            }
        } else {
            for (int i = 1; i <= 1000; i++) {
                if (arr[i] % 4 != 0) {
                    cant = true;
                    break;
                }
            }
        }

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {

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
