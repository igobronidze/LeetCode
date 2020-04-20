package com.codeforces.div3.finished.round579;

import java.io.*;
import java.util.*;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLong());
        }
        long x = list.get(0);

        Map<Long, Integer> dividers = new HashMap<>();
        for (long i = 2; i <= Math.sqrt(list.get(0)); i++) {
            while (x % i == 0) {
                if (!dividers.containsKey(i)) {
                    dividers.put(i, 0);
                }
                dividers.put(i, dividers.get(i) + 1);
                x = x / i;
            }
        }
        if (x > 1) {
            dividers.put(x, 1);
        }

        for (int i = 1; i < n; i++) {
            long y = list.get(i);
            for (long d : dividers.keySet()) {
                int c = 0;
                while (y % d == 0) {
                    c++;
                    y = y / d;
                }
                dividers.put(d, Math.min(dividers.get(d), c));
            }
        }

        long ans = 1;
        for (int c : dividers.values()) {
            ans = ans * (c + 1);
        }

        out.println(ans);




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
