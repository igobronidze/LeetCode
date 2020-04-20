package com.codeforces.educational.educational_85;

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
            long l = scanner.nextLong();
            long r = scanner.nextLong();

            long x = n, y = 1;
            for (int i = 1; i <= n - 1; i++) {
                if (l - (n - i) * 2 <= 0) {
                    x = i;
                    y = l;
                    break;
                } else {
                    l = l - (n - i) * 2;
                    r = r - (n - i) * 2;
                }
            }
            y = (y + 1) / 2 + x;
            for (long i = l; i <= r; i++) {
                if (x == n) {
                    out.print(1 + " ");
                } else {
                    if (i % 2 == 1) {
                        out.print(x + " ");
                    } else {
                        out.print(y + " ");
                        if (y == n) {
                            x++;
                            y = x + 1;
                        } else {
                            y++;
                        }
                    }
                }
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
