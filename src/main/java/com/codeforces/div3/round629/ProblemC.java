package com.codeforces.div3.round629;

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
            String s = scanner.next();
            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();

            boolean change = false;
            for (int i = 0; i < n; i++) {
                if (change) {
                    if (s.charAt(i) == '2') {
                        a.append('0');
                        b.append('2');
                    } else if (s.charAt(i) == '1') {
                        a.append('0');
                        b.append('1');
                    } else {
                        a.append('0');
                        b.append('0');
                    }
                } else {
                    if (s.charAt(i) == '2') {
                        a.append('1');
                        b.append('1');
                    } else if (s.charAt(i) == '1') {
                        a.append('1');
                        b.append('0');
                        change = true;
                    } else {
                        a.append('0');
                        b.append('0');
                    }
                }
            }
            out.println(a.toString());
            out.println(b.toString());
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
