package com.codeforces.div3.notfinished.round531;

import java.io.*;
import java.util.*;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            list.add(x);
            if (!map.containsKey(x)) {
                map.put(x, new Pair<>(i, -1));
            } else {
                map.get(x).second = i;
            }
        }

        int s = 0;
        int p = -1;
        for (int i = 0; i < n ; i++) {
            if (i > p) {
                s++;
            }
            p = Math.max(p, map.get(list.get(i)).second);
        }

        int mod = 998244353;
        long ans = 1;
        for (int i = 0; i < s - 1; i++) {
            ans = (ans * 2) % mod;
        }

        out.println(ans);


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

        public Pair() {
        }

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
