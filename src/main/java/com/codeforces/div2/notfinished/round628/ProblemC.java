package com.codeforces.div2.notfinished.round628;

import java.io.*;
import java.util.*;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (!map.containsKey(x)) {
                map.put(x, 0);
            }
            map.put(x, map.get(x) + 1);
            if (!map.containsKey(y)) {
                map.put(y, 0);
            }
            map.put(y, map.get(y) + 1);

            pairs.add(new Pair<>(x, y));
        }

//        int x = -1, y = -1, z = -1;
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() == 1) {
//                if (x == -1) {
//                    x = entry.getKey();
//                } else if (y == -1) {
//                    y = entry.getKey();
//                } else {
//                    z = entry.getKey();
//                    break;
//                }
//            }
//        }

        int a = 0, b = n -2;
        for (Pair<Integer, Integer> pair : pairs) {
            if (map.get(pair.first) == 1 || map.get(pair.second) == 1) {
                out.println(a);
                a++;
            } else {
                out.println(b);
                b--;
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
