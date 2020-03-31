package com.codeforces.div3.notfinished.round555;

import java.io.*;
import java.util.*;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (!map.containsKey(x)) {
                map.put(x, 0);
            }
            map.put(x, map.get(x) + 1);
        }

        for (int i = 0; i < n; i++) {
            int k = n - list.get(i) - 1;
            Map.Entry<Integer, Integer> entry = map.higherEntry(k);
            if (entry == null) {
                entry = map.firstEntry();
            }
            out.print((list.get(i) + entry.getKey()) % n + " ");
            if (entry.getValue() == 1) {
                map.remove(entry.getKey());
            } else {
                map.put(entry.getKey(), entry.getValue() - 1);
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
