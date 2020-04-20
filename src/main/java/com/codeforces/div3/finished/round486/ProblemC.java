package com.codeforces.div3.finished.round486;

import java.io.*;
import java.util.*;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int k = scanner.nextInt();
        Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();
        Pair<Integer, Integer> ans1 = null, ans2 = null;
        for (int p = 0; p < k; p++) {
            int n = scanner.nextInt();
            Map<Integer, Pair<Integer, Integer>> innerMap = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            int s = 0;
            for (int i = 0; i< n ; i++) {
                int x = scanner.nextInt();
                list.add(x);
                s += x;
            }

            for (int i = 0; i < n; i++) {
                int x = s - list.get(i);
                if (map.containsKey(x)) {
                    ans1 = map.get(x);
                    ans2 = new Pair<>(p + 1, i + 1);
                } else {
                    innerMap.put(x, new Pair<>(p + 1, i + 1));
                }
            }
            map.putAll(innerMap);
        }


        if (ans1 == null) {
            out.println("NO");
        } else {
            out.println("YES");
            out.println(ans1.first + " " + ans1.second);
            out.println(ans2.first + " " + ans2.second);
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
