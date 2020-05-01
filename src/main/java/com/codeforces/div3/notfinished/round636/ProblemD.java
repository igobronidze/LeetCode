package com.codeforces.div3.notfinished.round636;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(scanner.nextInt());
            }
            int[] sum = new int[k * 2 + 1];
            for (int i = 0; i < n / 2; i++) {
                sum[list.get(i) + list.get(n - i - 1)]++;
            }
            int[] min = new int[k + 1];
            int[] max = new int[k + 1];
            for (int i = 0; i < n; i++) {
                min[Math.min(list.get(i), list.get(n - i - 1))]++;
                max[Math.max(list.get(i), list.get(n - i - 1))]++;
            }
            for (int i = 1; i <= k; i++) {
                min[i] += min[i - 1];
                max[i] += max[i - 1];
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 2; i <= 2 * k; i++) {
                int m = 0;
                int x = n / 2 - sum[i];
                if (i <= k) {
                    m = m + (n / 2 - min[i]) * 2;
                    x = x - (n / 2 - min[i]);
                } else {
                    m = m + max[i - k - 1] * 2;
                    x = x - max[i - k - 1];
                }
                m = m + x;
                ans = Math.min(ans, m);
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
