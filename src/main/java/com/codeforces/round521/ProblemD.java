package com.codeforces.round521;

import java.io.*;
import java.util.*;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
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

        int x = solve(1, n, map, k);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue() / x; i++) {
                if (k > 0) {
                    out.print(entry.getKey() + " ");
                    k--;
                }
            }
        }



        out.flush();
    }

    private static int solve(int l, int r, Map<Integer, Integer> map, int k) {
        if (l == r) {
            return l;
        }
        if (l + 1 == r) {
            if (canSolve(r, map, k)) {
                return r;
            } else {
                return l;
            }
        }


        int mid = (l + r) / 2;
        if (canSolve(mid, map, k)) {
            return solve(mid, r, map, k);
        } else {
            return solve(l, mid - 1, map, k);
        }
    }

    private static boolean canSolve(int ind, Map<Integer, Integer> map, int k) {
        int sum = 0;
        for (int x : map.values()) {
            sum += x / ind;
        }
        return sum >= k;
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
