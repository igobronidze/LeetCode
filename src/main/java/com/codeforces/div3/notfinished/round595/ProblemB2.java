package com.codeforces.div3.notfinished.round595;

import java.io.*;
import java.util.*;

public class ProblemB2 {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int q = 0; q < t; q++) {
            int n = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(scanner.nextInt());
            }

            List<Integer> ans = new ArrayList<>();
            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int x = list.get(i);
                int a = 1;
                while (true) {
                    if (x == i + 1) {
                        break;
                    }
                    if (map.containsKey(x) && map.get(x).containsKey(i + 1)) {
                        a += map.get(x).get(i + 1);
                        break;
                    }
                    a++;
                    x = list.get(x - 1);
                    if (!map.containsKey(i + 1)) {
                        map.put(i + 1, new HashMap<>());
                    }
                    map.get(i + 1).put(x, a);
                }
                ans.add(a);
            }

            for (int x : ans) {
                out.print(x + " ");
            }
            out.println();
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

        public Pair() {
        }

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
