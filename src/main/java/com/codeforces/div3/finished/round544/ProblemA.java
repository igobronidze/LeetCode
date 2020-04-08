package com.codeforces.div3.finished.round544;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemA {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        String s = scanner.next();
        String t = scanner.next();
        int h1 = Integer.parseInt(s.split(":")[0]);
        int m1 = Integer.parseInt(s.split(":")[1]);
        int h2 = Integer.parseInt(t.split(":")[0]);
        int m2 = Integer.parseInt(t.split(":")[1]);

        int x = h2 * 60 + m2 - h1 * 60 - m1;

        m1 = m1 + x / 2;
        h1 = h1 + m1 / 60;
        m1 = m1 % 60;

        String s1 = "" + h1;
        if (s1.length() == 1) {
            s1 = "0" + s1;
        }
        String s2 = "" + m1;
        if (s2.length() == 1) {
            s2 = "0" + m1;
        }


        out.print(s1 + ":" + s2);




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