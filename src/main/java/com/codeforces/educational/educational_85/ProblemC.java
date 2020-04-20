package com.codeforces.educational.educational_85;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
            List<Pair<Long, Long>> list = new ArrayList<>();
            List<Long> diffs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new Pair<>(scanner.nextLong(), scanner.nextLong()));
            }

            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    diffs.add(list.get(i).first - Math.max(list.get(i).first - list.get(n - 1).second, 0));
                } else {
                    diffs.add(list.get(i).first - Math.max(list.get(i).first - list.get(i - 1).second, 0));
                }
            }

            int minDifInd = 0;
            for (int i = 0; i < n; i++) {
                if (diffs.get(i) < diffs.get(minDifInd)) {
                    minDifInd = i;
                }
            }

            long s = 0;
            for (int i = 0; i < n; i++) {
                if (i == minDifInd) {
                    s += list.get(i).first;
                } else {
                    s += (list.get(i).first - diffs.get(i));
                }
            }
            out.println(s);
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
