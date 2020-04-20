package com.codeforces.div3.notfinished.round550;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        int[] count = new int[200008];
        int ind = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            list.add(x);
            count[x]++;
            if (count[x] > count[list.get(ind)]) {
                ind = i;
            }
        }

        int x = list.get(ind);
        List<Triple<Integer, Integer, Integer>> ans = new ArrayList<>();
        for (int i = ind - 1; i >= 0; i--) {
            if (list.get(i) > x) {
                ans.add(new Triple<>(2, i + 1, i + 2));
            } else if (list.get(i) < x) {
                ans.add(new Triple<>(1, i + 1, i + 2));
            }
        }

        for (int i = ind + 1; i < n; i++) {
            if (list.get(i) > x) {
                ans.add(new Triple<>(2, i + 1, i));
            } else if (list.get(i) < x) {
                ans.add(new Triple<>(1, i + 1, i));
            }
        }

        out.println(ans.size());
        for (Triple<Integer, Integer, Integer> an : ans) {
            out.println(an.first + " " + an.second + " " + an.third);
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
