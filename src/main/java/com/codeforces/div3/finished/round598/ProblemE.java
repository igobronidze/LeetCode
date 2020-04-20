package com.codeforces.div3.finished.round598;

import java.io.*;
import java.util.*;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair<>(scanner.nextInt(), i));
        }

        int[] ans = new int[n + 1];

        Collections.sort(list, Comparator.comparingInt(a -> a.first));

        Pair<Long, Integer>[] dp = new Pair[n + 1];
        dp[2] = new Pair<>((long) list.get(2).first - list.get(0).first, 3);
        if (n > 3) {
            dp[3] = new Pair<>((long) list.get(3).first - list.get(0).first, 4);
        }
        if (n > 4) {
            dp[4] = new Pair<>((long) list.get(4).first - list.get(0).first, 5);
        }

        for (int i = 5; i < n; i++) {
            long min = Long.MAX_VALUE;
            int x = 0;
            for (int k = 3; k <= 5; k++) {
                long s = Long.MAX_VALUE;
                if (dp[i - k] != null) {
                    s = dp[i - k].first + (list.get(i).first - list.get(i - k + 1).first);
                }
                if (s < min) {
                    min = s;
                    x = k;
                }
            }
            dp[i] = new Pair<>(min, x);
        }

        int ind = n - 1;
        int x = 1;
        while (ind > 0) {
            for (int i = ind; i > ind - dp[ind].second; i--) {
                ans[list.get(i).second] = x;
            }
            ind = ind - dp[ind].second;
            x++;
        }

        out.println(dp[n - 1].first + " " + (x - 1));
        for (int i = 0; i < n; i++) {
            out.print(ans[i] + " ");
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
