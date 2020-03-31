package com.codeforces.div3.notfinished.round531;

import java.io.*;
import java.util.*;

public class ProblemB {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        int[] count = new int[5001];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            pairs.add(new Pair<>(x, i));
            count[x]++;
            max = Math.max(max, count[x]);
        }

        if (k > n) {
            out.println("NO");
        } else if (max > k) {
            out.println("NO");
        } else {
            out.println("YES");
            pairs.sort(Comparator.comparingInt(a -> a.first));

            int[] ans = new int[n];
            int x = 1;
            for (int i = 0; i < n; i++) {
                ans[pairs.get(i).second] = x;
                x++;
                if (x == k + 1) {
                    x = 1;
                }
            }
            for (int i = 0; i < n; i++) {
                out.print(ans[i] + " ");
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
}
