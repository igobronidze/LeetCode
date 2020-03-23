package com.codeforces.round531;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        String s = scanner.next();
        int a = 0, b = 0,  c = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                a++;
            } else if (s.charAt(i) == '1') {
                b++;
            } else {
                c++;
            }
        }

        int x = 0, y = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (a > n / 3 && x == n / 3) {
                    if (b < n / 3) {
                        sb.append('1');
                        b++;
                    } else {
                        sb.append('2');
                        c--;
                    }
                    a--;
                } else {
                    x++;
                    sb.append('0');
                }
            }
            if (s.charAt(i) == '1') {
                if (b > n / 3) {
                    if (a < n / 3) {
                        sb.append('0');
                        a++;
                        b--;
                    } else if (y == n / 3) {
                        sb.append('2');
                        c++;
                        b--;
                    } else {
                        sb.append('1');
                        y++;
                    }
                } else {
                    y++;
                    sb.append('1');
                }
            }
            if (s.charAt(i) == '2') {
                if (c > n / 3) {
                    if (a < n / 3) {
                        sb.append('0');
                        a++;
                    } else {
                        sb.append('1');
                        b++;
                    }
                    c--;
                } else {
                    sb.append('2');
                }
            }
        }
        out.println(sb.toString());



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
