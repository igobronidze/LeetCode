package com.codeforces.div3.finished.round535;

import java.io.*;
import java.util.*;

public class ProblemE_2 {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = scanner.nextInt();
        }

        Map<Integer, List<Integer>> leftMap = new HashMap<>();
        Map<Integer, List<Integer>> rightMap = new HashMap<>();
        List<Pair<Integer, Integer>> segments = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            if (!leftMap.containsKey(x)) {
                leftMap.put(x, new ArrayList<>());
            }
            if (!rightMap.containsKey(y)) {
                rightMap.put(y, new ArrayList<>());
            }
            leftMap.get(x).add(y);
            rightMap.get(y).add(x);
            segments.add(new Pair<>(x, y));
        }

        int minIndex = -1;
        int min = list[0];
        int max = list[0];
        for (int i = 0; i < n; i++) {
            if (list[i] < min) {
                min = list[i];
                minIndex = i;
            }
            if (list[i] > max) {
                max = list[i];
            }
        }

        for (int i = 0; i < n; i++) {
            boolean reCalculate = false;
            if (leftMap.containsKey(i)) {
                for (int y : leftMap.get(i)) {
                    for (int j = i; j <= y; j++) {
                        list[j]--;
                    }
                }
                reCalculate = true;
            }
            if (rightMap.containsKey(i - 1)) {
                for (int x : rightMap.get(i - 1)) {
                    for (int j = x; j <= i - 1; j++) {
                        list[j]++;
                    }
                }
                reCalculate = true;
            }
            if (reCalculate) {
                int innerMin = Integer.MAX_VALUE;
                int innerMax = Integer.MIN_VALUE;
                for (int x : list) {
                    innerMin = Math.min(innerMin, x);
                    innerMax = Math.max(innerMax, x);
                }
                if (innerMax - innerMin > max - min) {
                    max = innerMax;
                    min = innerMin;
                    minIndex = i;
                }
            }
        }

        out.println(max - min);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            Pair<Integer, Integer> segment = segments.get(i);
            if (segment.first <= minIndex && segment.second >= minIndex) {
                ans.add(i + 1);
            }
        }

        out.println(ans.size());
        for (int x : ans) {
            out.print(x + " ");
        }
        out.println();




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