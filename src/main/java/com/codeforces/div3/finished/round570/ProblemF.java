package com.codeforces.div3.finished.round570;

import java.io.*;
import java.util.*;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(scanner.nextInt());
            }
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            Collections.reverse(list);
            int max = Integer.MIN_VALUE;
            n = list.size();
            for (int i = 0; i < n; i++) {
                int m = list.get(i);
                int k = n;
                for (int j = i + 1; j < n; j++) {
                    if (list.get(i) % list.get(j) != 0) {
                        k = j;
                        m += list.get(j);
                        break;
                    }
                }
                for (int j = k; j < n; j++) {
                    if (list.get(i) % list.get(j) != 0 && list.get(k) % list.get(j) != 0) {
                        m += list.get(j);
                        break;
                    }
                }
                max = Math.max(max, m);
            }
            out.println(max);
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
