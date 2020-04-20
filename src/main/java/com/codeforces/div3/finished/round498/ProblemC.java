package com.codeforces.div3.finished.round498;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemC {

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
        long[] left = new long[n + 1];
        long[] right = new long[n + 1];
        left[0] = list.get(0);
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + list.get(i);
        }
        right[n - 1] = list.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + list.get(i);
        }

        int i = 0, j = n - 1;
        long ans = 0;
        while (i < j) {
            if (left[i] == right[j]) {
                ans = Math.max(ans, left[i]);
                i++;
                j--;
            } else if (left[i] > right[j]) {
                j--;
            } else {
                i++;
            }
        }

        out.print(ans);




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
