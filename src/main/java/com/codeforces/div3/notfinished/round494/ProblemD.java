package com.codeforces.div3.notfinished.round494;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] powers = new int[32];
        int[] copy = new int[32];

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int a = 0;
            while (x != 1) {
                a++;
                x = x / 2;
            }
            powers[a]++;
            copy[a]++;
        }

        for (int p = 0; p < q; p++) {
            int x = scanner.nextInt();
            String s = Integer.toBinaryString(x);
            boolean cant = false;
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                int k = s.length() - i - 1;
                int c = s.charAt(i) - '0';
                for (int j = k; j >= 0; j--) {
                    if (powers[j] >= c) {
                        ans += c;
                        powers[j] = powers[j] - c;
                        c = 0;
                        break;
                    } else {
                        ans += powers[j];
                        c = c - powers[j];
                        powers[j] = 0;
                        c = c * 2;
                    }
                }
                if (c > 0) {
                    cant = true;
                    break;
                }
            }
            if (cant) {
                out.println(-1);
            } else {
                out.println(ans);
            }

            System.arraycopy(copy, 0, powers, 0, 32);
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

    private static class Triple<F, S, T> {

        private F first;

        private S second;

        private T third;

        public Triple() {
        }

        public Triple(F first, S second, T third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}
