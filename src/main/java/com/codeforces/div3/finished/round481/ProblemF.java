package com.codeforces.div3.finished.round481;

import java.io.*;
import java.util.*;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            list.add(x);
            pairs.add(new Pair<>(x, i));
        }
        pairs.sort(Comparator.comparingInt(a -> a.first));

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int x = scanner.nextInt();
            x--;
            int y = scanner.nextInt();
            y--;
            if (!map.containsKey(x)) {
                map.put(x, new ArrayList<>());
            }
            map.get(x).add(y);
            if (!map.containsKey(y)) {
                map.put(y, new ArrayList<>());
            }
            map.get(y).add(x);
        }


        int[] ans = new int[n];
        int eq = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                if (pairs.get(i).first.equals(pairs.get(i - 1).first)) {
                    eq++;
                } else {
                    eq = 0;
                }
            }
            ans[pairs.get(i).second] += (i - eq);

            if (map.containsKey(pairs.get(i).second)) {
                for (int x : map.get(pairs.get(i).second)) {
                    if (list.get(x) > list.get(pairs.get(i).second)) {
                        ans[x]--;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            out.print(ans[i] + " ");
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
