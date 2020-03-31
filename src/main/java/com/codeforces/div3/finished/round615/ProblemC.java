package com.codeforces.div3.finished.round615;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();

            double s = Math.sqrt(n);
            int k = 0;
            int a = 0, b = 0, c = 0;
            for (int i = 2; i <= s; i++) {
                if (n % i == 0) {
                    if (a == 0) {
                        a = i;
                    } else {
                        b = i;
                        c = n / i;
                        break;
                    }
                    n = n / i;
                }
            }
            if (c == 0) {
                out.println("NO");
            } else {
                if (a == b || a == c || b == c) {
                    out.println("NO");
                } else {
                    out.println("YES");
                    out.println(a + " " + b + " " + c);
                }
            }
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
