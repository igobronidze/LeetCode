package com.codeforces.div3.finished.round479;

import java.io.*;
import java.util.*;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLong());
        }

        Map<Integer, Long> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int c = 0;
            long x = list.get(i);
            while (x % 3 == 0) {
                c++;
                x = x / 3;
            }
            if (!map.containsKey(c)) {
                map.put(c, 0L);
            }
            map.put(c, Math.max(map.get(c), list.get(i)));
        }

        long first = 0L;
        for (Long x : map.values()) {
            first = x;
        }

        while (first % 2 == 0 && list.contains(first / 2)) {
            first = first / 2;
        }

        out.print(first + " ");
        for (int i = 1; i < n; i++) {
            if (first % 3 == 0 && list.contains(first / 3)) {
                first = first / 3;
            } else {
                first = first * 2;
            }
            out.print(first + " ");
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
