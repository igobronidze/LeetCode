package com.codeforces.div3.finished.round552;

import java.io.*;
import java.util.*;

public class ProblemG {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = 10_000_000;
        Pair<Integer, Integer>[] map = new Pair[m + 1];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            Pair<Integer, Integer> pair = map[x];
            if (pair == null) {
                map[x] = new Pair<>(i + 1, 0);
            } else if (pair.second == 0) {
                pair.second = i + 1;
            }
        }

        long ans = Long.MAX_VALUE;
        int ff = 0, ss = 0;
        Integer first = null, second = null;
        for (int i = 1; i <= m; i++) {
            first = null;
            second = null;
            for (int k = i; k <= m; k += i) {
                Pair<Integer, Integer> pair = map[k];
                if (pair != null) {
                    if (first == null) {
                        if (pair.second != 0) {
                            first = k;
                            second = k;
                            break;
                        } else {
                            first = k;
                        }
                    } else {
                        second = k;
                        break;
                    }
                }
            }
            if (second != null) {
                long s = (long)first * second / i;
                if (ans > s) {
                    ans = s;
                    ff = first;
                    ss = second;
                }
            }
        }

        if (ff == ss) {
            out.println(map[ff].first + " " + map[ss].second);
        } else {
            int x = map[ff].first;
            int y = map[ss].first;
            out.println(Math.min(x, y) + " " + Math.max(x, y));
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
