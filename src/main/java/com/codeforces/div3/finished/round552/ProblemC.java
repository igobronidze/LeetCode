package com.codeforces.div3.finished.round552;

import java.io.*;
import java.util.*;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 0);
        map.put(4, 2);
        map.put(5, 1);
        map.put(6, 0);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int ans = 0;
        for (int i = 0; i <= 6; i++) {
            List<Integer> list = Arrays.asList(a, b, c);
            int x = 0;
            for (int j = i; j <= 6; j++) {
                int ind = map.get(j);
                if (list.get(ind) == 0) {
                    break;
                } else {
                    list.set(ind, list.get(ind) - 1);
                    x++;
                }
            }
            int m = Math.min(list.get(0) / 3, list.get(1) / 2);
            m = Math.min(m, list.get(2) / 2);
            x += m * 7;
            list.set(0, list.get(0) - m * 3);
            list.set(1, list.get(1) - m * 2);
            list.set(2, list.get(2) - m * 2);
            for (int j = 0; j <= 6; j++) {
                int ind = map.get(j);
                if (list.get(ind) == 0) {
                    break;
                } else {
                    list.set(ind, list.get(ind) - 1);
                    x++;
                }
            }
            ans = Math.max(ans, x);
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
