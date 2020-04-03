package com.codeforces.div2.notfinished.round630;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int k = scanner.nextInt();

        String s = Integer.toBinaryString(k);
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i <= s.length(); i++) {
            sb1.append('1');
        }
        StringBuilder sb2 = new StringBuilder("1");
        for (int i = 0; i < s.length(); i++) {
            sb2.append('0');
        }

        int a = binaryToInt(sb1.toString());
        int b = binaryToInt(sb2.toString());

        out.println("3 3");
        out.println(a + " " + k + " " + 0);
        out.println(b + " " + k + " " + 0);
        out.println(a + " " + a + " " + k);



        out.flush();
    }

    private static int binaryToInt(String s) {
        int x = 1;
        int p = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                p = p + x;
            }
            x = x * 2;
        }
        return p;
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
