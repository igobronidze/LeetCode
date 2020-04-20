package com.codeforces.div3.finished.round590;

import java.io.*;
import java.util.*;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer> xList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            xList.add(x);
        }

        List<Integer>[] adjacents = new ArrayList[n + 1];
        Map<Integer, Integer> positions = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adjacents[i] = new ArrayList<>();
            positions.put(i, i);
        }
        for (int i = 0; i < m; i++) {
            if (i != 0) {
                adjacents[xList.get(i)].add(xList.get(i - 1));
            }
            if (i != m - 1) {
                adjacents[xList.get(i)].add(xList.get(i + 1));
            }
        }


        long fp1 = 0;
        for (int i = 1; i <= n; i++) {
            for (int x : adjacents[i]) {
                fp1 += Math.abs(positions.get(i) - positions.get(x));
            }
        }
        List<Long> ans = new ArrayList<>();
        ans.add(fp1 / 2);

        for (int i = 1; i < n; i++) {
            long change = 0;
            for (int x : adjacents[i]) {
                change -= Math.abs(positions.get(i) - positions.get(x));
            }
            for (int x : adjacents[i + 1]) {
                change -= Math.abs(positions.get(i + 1) - positions.get(x));
            }

            int tmp = positions.get(i);
            positions.put(i, positions.get(i + 1));
            positions.put(i + 1, tmp);

            for (int x : adjacents[i]) {
                change += Math.abs(positions.get(i) - positions.get(x));
            }
            for (int x : adjacents[i + 1]) {
                change += Math.abs(positions.get(i + 1) - positions.get(x));
            }

            ans.add(ans.get(i - 1) + change);
        }




        for (long l : ans) {
            out.print(l + " ");
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
