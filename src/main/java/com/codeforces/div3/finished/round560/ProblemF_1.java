package com.codeforces.div3.finished.round560;

import java.io.*;
import java.util.*;

public class ProblemF_1 {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer> amounts = new ArrayList<>();
        List<Pair<Integer, Integer>> salePairs = new ArrayList<>();
        int s = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            s = s + x;
            amounts.add(x);
        }

        for (int i = 0; i < m; i++) {
            salePairs.add(new Pair<>(scanner.nextInt(), scanner.nextInt()));
        }

        out.println(solve(amounts, salePairs, s, 1, 2 * s));


        out.flush();
    }

    private static int solve(List<Integer> amounts, List<Pair<Integer, Integer>> salePairs, int sum, int l, int r) {
        if (l == r) {
            return l;
        }
        if (l + 1 == r) {
            if (canSolve(amounts, salePairs, sum, l)) {
                return l;
            } else {
                return r;
            }
        }
        int mid = (l + r) / 2;
        if (canSolve(amounts, salePairs, sum, mid)) {
            return solve(amounts, salePairs, sum, l, mid);
        } else {
            return solve(amounts, salePairs, sum, mid + 1, r);
        }
    }

    private static boolean canSolve(List<Integer> amounts, List<Pair<Integer, Integer>> salePairs, int sum, int lastDay) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Pair<Integer, Integer> pair : salePairs) {
            if (pair.first <= lastDay) {
                if (map.containsKey(pair.second)) {
                    if (map.get(pair.second) < pair.first) {
                        map.put(pair.second, pair.first);
                    }
                } else {
                    map.put(pair.second, pair.first);
                }
            }
        }

        Map<Integer, List<Integer>> sales = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (!sales.containsKey(entry.getValue())) {
                sales.put(entry.getValue(), new ArrayList<>());
            }
            sales.get(entry.getValue()).add(entry.getKey());
        }


        int x = 0;
        for (int i = 1; i <= lastDay; i++) {
            x++;
            if (sales.containsKey(i)) {
                for (int t : sales.get(i)) {
                    if (x > amounts.get(t - 1)) {
                        sum = sum - amounts.get(t - 1);
                        x = x - amounts.get(t - 1);
                    } else {
                        sum = sum - x;
                        x = 0;
                    }
                }
            }
            if (sum * 2 <= x) {
                break;
            }
        }
        return sum * 2 <= x;
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

        public Pair() {
        }

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
