package com.codeforces.round529;

import java.io.*;
import java.util.*;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        Map<Integer, Pair<Integer, Integer>> map = new HashMap<>(n);
        for (int i = 1; i <= n; i++) {
            map.put(i, new Pair<>());
        }

        List<Integer> ans = new ArrayList<>();
        int a = 0 , b = 0;

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (i == 0) {
                a = x;
                b = y;
            }
            if (map.get(x).first == null) {
                map.get(x).first = y;
            } else {
                map.get(x).second = y;
            }
            if (map.get(y).first == null) {
                map.get(y).first = x;
            } else {
                map.get(y).second = x;
            }
        }

        if (map.get(1).first == a || map.get(1).second == a) {
            ans.add(a);
            ans.add(b);
        } else {
            ans.add(b);
            ans.add(a);
        }

        for (int i = 2; i < n ; i++) {
            int last = ans.get(i - 1);
            int prevOfLast = ans.get(i - 2);
            if (map.get(last).first == prevOfLast) {
                ans.add(map.get(last).second);
            } else {
                ans.add(map.get(last).first);
            }
        }

        for (int i = 0; i < n; i++) {
            out.print(ans.get(i) + " ");
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
