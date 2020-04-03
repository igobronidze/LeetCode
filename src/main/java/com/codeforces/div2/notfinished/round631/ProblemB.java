package com.codeforces.div2.notfinished.round631;

import java.io.*;
import java.util.*;

public class ProblemB {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(scanner.nextInt());
            }

            boolean[] isPerm = new boolean[n + 1];
            Set<Integer> set = new HashSet<>();
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (set.contains(list.get(i))) {
                    break;
                }
                set.add(list.get(i));
                max = Math.max(max, list.get(i));
                if (max == i + 1) {
                    isPerm[i] = true;
                }
            }

            set = new HashSet<>();
            max = 0;
            List<Pair<Integer, Integer>> ans = new ArrayList<>();
            for (int i = n - 1; i > 0; i--) {
                if (set.contains(list.get(i))) {
                    break;
                }
                set.add(list.get(i));
                max = Math.max(max, list.get(i));
                if (max == n - i && isPerm[i - 1]) {
                    ans.add(new Pair<>(i, n - i));
                }
            }

            out.println(ans.size());
            for (Pair<Integer, Integer> pair : ans) {
                out.println(pair.first + " " + pair.second);
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
