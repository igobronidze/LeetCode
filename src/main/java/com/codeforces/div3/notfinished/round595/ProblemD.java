package com.codeforces.div3.notfinished.round595;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int m = 200002;
        int[] points = new int[m];
        List<Pair<Integer, Integer>>[] segments = new ArrayList[m];
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            points[l]++;
            points[r + 1]--;
            if (segments[l] == null) {
                segments[l] = new ArrayList<>();
            }
            segments[l].add(new Pair<>(r, i + 1));
        }

        for (int i = 1; i < points.length; i++) {
            points[i] += points[i - 1];
        }

        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair<Integer, Integer>> segmentEnds = new PriorityQueue<>((a, b) -> Integer.compare(b.first, a.first));
        PriorityQueue<Integer> removedEnds = new PriorityQueue<>();
        for (int i = 1; i < m; i++) {
            if (segments[i] != null) {
                for (Pair<Integer, Integer> pair : segments[i]) {
                    segmentEnds.add(pair);
                }
            }

            while (points[i] - removedEnds.size() > k) {
                Pair<Integer, Integer> pair = segmentEnds.poll();
                removedEnds.add(pair.first);
                ans.add(pair.second);
            }

            while (!removedEnds.isEmpty() && removedEnds.peek() == i) {
                removedEnds.poll();
            }
        }

        out.println(ans.size());
        for (int x : ans) {
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
}
