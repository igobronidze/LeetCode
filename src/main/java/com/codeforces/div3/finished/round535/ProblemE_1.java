package com.codeforces.div3.finished.round535;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemE_1 {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            pairs.add(new Pair<>(scanner.nextInt() - 1, scanner.nextInt() - 1));
        }

        int ind = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            List<Integer> copy = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                copy.add(list.get(j));
            }

            for (int j = 0; j < m; j++) {
                if (pairs.get(j).first > i || pairs.get(j).second < i) {
                    for (int k = pairs.get(j).first; k <= pairs.get(j).second; k++) {
                        copy.set(k, copy.get(k) - 1);
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int x : copy) {
                min = Math.min(min, x);
                max = Math.max(max, x);
            }
            if (max - min > ans) {
                ans = max - min;
                ind = i;
            }
        }

        out.println(ans);
        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (pairs.get(i).first > ind || pairs.get(i).second < ind) {
                ansList.add(i + 1);
            }
        }

        out.println(ansList.size());
        for (int x : ansList) {
            out.print(x + " ");
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
