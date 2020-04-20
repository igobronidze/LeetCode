package com.codeforces.div3.finished.round582;

import java.io.*;
import java.util.*;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            Set<Integer> set = new HashSet<>();
            int x = i;
            int s = 0;
            while (true) {
                if (set.contains(x)) {
                    break;
                } else {
                    set.add(x);
                    s = s + x;
                    x = (x + i) % 10;
                }
            }
            map.put(i, new Pair<>(set.size(), s));
        }

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            long n = scanner.nextLong();
            long m = scanner.nextLong();

            long k = n / m;
            Pair<Integer, Integer> pair = map.get((int)(m % 10));
            long ans = k / pair.first * pair.second;
            k = k % pair.first;
            long x = m % 10;
            long y = x;
            for (int i = 0; i < k; i++) {
                ans += x;
                x = (x + y) % 10;
            }
            out.println(ans);
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
