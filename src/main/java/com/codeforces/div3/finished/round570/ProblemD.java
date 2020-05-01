package com.codeforces.div3.finished.round570;

import java.io.*;
import java.util.*;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                if (!map.containsKey(x)) {
                    map.put(x, 0);
                }
                map.put(x, map.get(x) + 1);
            }

            List<Integer> countOfTypes = new ArrayList<>(map.values());
            Collections.sort(countOfTypes);
            Collections.reverse(countOfTypes);
            int x = countOfTypes.get(0);
            long ans = x;
            for (int i = 1; i < countOfTypes.size(); i++) {
                if (countOfTypes.get(i) >= x - 1) {
                    x--;
                } else {
                    x = countOfTypes.get(i);
                }
                if (x <= 0) {
                    break;
                }
                ans += x;
            }
            out.println(ans);
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
