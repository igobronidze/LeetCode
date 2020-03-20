package com.codeforces.round506;

import java.io.*;
import java.util.*;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        List<Pair<Integer, Integer>> segments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            segments.add(new Pair<>(scanner.nextInt(), scanner.nextInt()));
        }

        List<Pair<Integer, Integer>> intersectionsLeft = getIntersections(segments);
        Collections.reverse(segments);
        List<Pair<Integer, Integer>> intersectionsRight = getIntersections(segments);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            Pair<Integer, Integer> left = i == 0 ? null : intersectionsLeft.get(i - 1);
            Pair<Integer, Integer> right = i == n - 1 ? null : intersectionsRight.get(n - i - 2);
            Pair<Integer, Integer> merged = merge(left, right);
            ans = Math.max(ans, merged.second - merged.first);
        }

        out.println(ans);

        out.flush();
    }

    private static List<Pair<Integer, Integer>> getIntersections(List<Pair<Integer, Integer>> segments) {
        List<Pair<Integer, Integer>> intersections = new ArrayList<>();
        Pair<Integer, Integer> intersection = new Pair<>(Integer.MIN_VALUE, Integer.MAX_VALUE);
        for (int i = 0; i < segments.size(); i++) {
            intersection = merge(intersection, segments.get(i));
            intersections.add(new Pair<>(intersection.first, intersection.second));
        }
        return intersections;
    }

    private static Pair<Integer, Integer> merge(Pair<Integer, Integer> left, Pair<Integer, Integer> right) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        Pair<Integer, Integer> merged = new Pair<>();
        merged.first = Math.max(left.first, right.first);
        merged.second = Math.min(left.second, right.second);

        return merged;
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
