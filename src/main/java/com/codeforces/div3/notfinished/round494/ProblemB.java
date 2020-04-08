package com.codeforces.div3.notfinished.round494;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemB {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int x = scanner.nextInt();

        StringBuilder sb = new StringBuilder();
        boolean bool = false;
        int pa = a;
        int pb = b;
        if (a >= b) {
            for (int i = 0; i < a + b; i++) {
                if (x == 1) {
                    if (bool) {
                        for (int j = 0; j < pb; j++) {
                            sb.append('1');
                        }
                        for (int j = 0; j < pa; j++) {
                            sb.append('0');
                        }
                    } else {
                        for (int j = 0; j < pa; j++) {
                            sb.append('0');
                        }
                        for (int j = 0; j < pb; j++) {
                            sb.append('1');
                        }
                    }
                    break;
                } else {
                    if (bool) {
                        sb.append('1');
                        pb--;
                    } else {
                        sb.append('0');
                        pa--;
                    }
                    bool = !bool;
                    x--;
                }
            }
        } else {
            for (int i = 0; i < a + b; i++) {
                if (x == 1) {
                    if (bool) {
                        for (int j = 0; j < pa; j++) {
                            sb.append('0');
                        }
                        for (int j = 0; j < pb; j++) {
                            sb.append('1');
                        }
                    } else {
                        for (int j = 0; j < pb; j++) {
                            sb.append('1');
                        }
                        for (int j = 0; j < pa; j++) {
                            sb.append('0');
                        }
                    }
                    break;
                } else {
                    if (bool) {
                        sb.append('0');
                        pa--;
                    } else {
                        sb.append('1');
                        pb--;
                    }
                    bool = !bool;
                    x--;
                }
            }
        }

        out.println(sb.toString());




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
