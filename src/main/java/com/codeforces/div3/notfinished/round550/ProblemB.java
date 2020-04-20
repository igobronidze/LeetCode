package com.codeforces.div3.notfinished.round550;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemB {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (x % 2 == 0) {
                evens.add(x);
            } else {
                odds.add(x);
            }
            sum += x;
        }

        Collections.sort(evens);
        Collections.sort(odds);
        Collections.reverse(evens);
        Collections.reverse(odds);

        for (int i = 0; i < Math.min(evens.size(), odds.size()); i++) {
            sum -= evens.get(i);
            sum -= odds.get(i);
        }

        if (evens.size() > odds.size()) {
            sum -= evens.get(odds.size());
        } else if (odds.size() > evens.size()) {
            sum -= odds.get(evens.size());
        }

        out.println(sum);



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
