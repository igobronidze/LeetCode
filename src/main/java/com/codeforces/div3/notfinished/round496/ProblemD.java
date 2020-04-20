package com.codeforces.div3.notfinished.round496;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        String s = scanner.next();
        int n = s.length();
        Integer bef = null, befTwo = null;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) % 3 == 0) {
                ans++;
                bef = null;
                befTwo= null;
            } else if (s.charAt(i) % 3 == 1) {
                if (bef != null && bef == 2) {
                    ans++;
                    bef = null;
                    befTwo= null;
                } else if (bef != null && bef == 1 && befTwo != null && 1 == befTwo) {
                    ans++;
                    bef = null;
                    befTwo= null;
                } else {
                    befTwo = bef;
                    bef = s.charAt(i) % 3;
                }
            } else {
                if (bef != null && bef == 1) {
                    ans++;
                    bef = null;
                    befTwo= null;
                } else if (bef != null && bef == 2 && befTwo != null && 2 == befTwo) {
                    ans++;
                    bef = null;
                    befTwo= null;
                } else {
                    befTwo = bef;
                    bef = s.charAt(i) % 3;
                }
            }
        }

        out.println(ans);





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
