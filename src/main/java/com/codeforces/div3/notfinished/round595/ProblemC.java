package com.codeforces.div3.notfinished.round595;

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

        int t = scanner.nextInt();
        List<Long> powers = new ArrayList<>();
        long x = 1;
        try {
            for (int i = 1; i < 50; i++) {
                powers.add(x);
                x = Math.multiplyExact(x, 3);
            }
        } catch (ArithmeticException ignored) {}

        long[] sum = new long[powers.size()];

        sum[0] = powers.get(0);
        try {
            for (int i = 1; i < powers.size(); i++) {
                sum[i] = Math.addExact(sum[i - 1], powers.get(i));
            }
        } catch (ArithmeticException ignored) {}

        for (int p = 0; p < t; p++) {
            long n = scanner.nextLong();

            long ans = 0;
            while (n > 0) {
                for (int i = 0; i < powers.size(); i++) {
                    if (sum[i] >= n) {
                        n = n - powers.get(i);
                        ans = ans + powers.get(i);
                        break;
                    }
                }
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
}
