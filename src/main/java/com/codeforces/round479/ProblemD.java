package com.codeforces.round479;

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

        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(list.get(i))) {
                map.put(list.get(i), 0);
            }
            map.put(list.get(i), map.get(list.get(i)) + 1);
        }

        long first = -1;
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                first = entry.getKey();
            }
        }
        if (first == -1) {
            first = list.get(0);
        }

        boolean[] used = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            if (list.get(i) == first) {
                used[i] = true;
                break;
            }
        }

        List<Long> ans = new ArrayList<>();
        ans.add(first);
        while (ans.size() != n) {
            for (int i = 0; i < n; i++) {
                if (!used[i] && (first * 2 == list.get(i) || list.get(i) * 3 == first)) {
                    ans.add(list.get(i));
                    first = list.get(i);
                }
            }
        }

        for (long x : ans) {
            out.print(x + " ");
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
