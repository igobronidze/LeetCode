package com.codeforces.div3.notfinished.round496;

import java.io.*;
import java.util.*;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            list.add(x);
            if (!map.containsKey(x)) {
                map.put(x, 0);
            }
            map.put(x, map.get(x) + 1);
        }

        List<Integer> powers = new ArrayList<>();
        int x = 1;
        try {
            while (true) {
                powers.add(x);
                x = Math.multiplyExact(x, 2);
            }
        } catch (ArithmeticException ex) {}

        int ans = 0;
        for (int i = 0; i < n; i++) {
            boolean find = false;
            for (int p : powers) {
                if (p > list.get(i)) {
                    int y = p - list.get(i);
                    if (map.containsKey(y)) {
                        if (y != list.get(i) || map.get(y) != 1) {
                            find = true;
                            break;
                        }
                    }
                }
            }
            if (!find) {
                ans++;
            }
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
