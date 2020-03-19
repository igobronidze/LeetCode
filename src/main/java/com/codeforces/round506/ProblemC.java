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

        Collections.sort(segments, (a, b) -> {
            int x = Integer.compare(a.first, b.first);
            if (x != 0) {
                return x;
            } else {
                return Integer.compare(a.second, b.second);
            }
        });

        Map<Integer, Integer> countSegmentsInPoint = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int x = segments.get(i).first;
            int y = segments.get(i).second;
            if (!countSegmentsInPoint.containsKey(x)) {
                countSegmentsInPoint.put(x, 0);
            }
            if (!countSegmentsInPoint.containsKey(y)) {
                countSegmentsInPoint.put(y, 0);
            }
            countSegmentsInPoint.put(x, countSegmentsInPoint.get(x) + 1);
            countSegmentsInPoint.put(y, countSegmentsInPoint.get(y) - 1);
        }


        int x = 0;
        int y = 0;
        Map<Integer, Integer> countNMinusOnePoints = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : countSegmentsInPoint.entrySet()) {
            countNMinusOnePoints.put(entry.getKey(), y);
            if (entry.getValue() == n) {
                x++;
            } else if (entry.getValue() == n - 1) {
                y++;
            }
        }

        int max = 0;
        for (Pair<Integer, Integer> segment : segments) {
            max = Math.max(max, countNMinusOnePoints.get(segment.second) - countNMinusOnePoints.get(segment.first));
        }

        out.println(max + x);


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
