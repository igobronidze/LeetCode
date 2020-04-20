package com.codeforces.div3.finished.round498;

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
        String t = scanner.next();

        int ans = 0;
        for (int i = 0; i < n / 2; i++) {
            int j = n - i - 1;
            if (s.charAt(i) == t.charAt(i) && s.charAt(j) == t.charAt(j)) {
                continue;
            }
            if (s.charAt(i) == t.charAt(j) && s.charAt(j) == t.charAt(i)) {
                continue;
            }
            if (s.charAt(i) == s.charAt(j) && t.charAt(i) == t.charAt(j)) {
                continue;
            }
            if (s.charAt(i) == t.charAt(i) || s.charAt(i) == t.charAt(j) || s.charAt(j) == t.charAt(i) || s.charAt(j) == t.charAt(j)) {
                ans++;
            } else if (t.charAt(i) == t.charAt(j)) {
                ans++;
            } else {
                ans += 2;
            }
        }

        if (n % 2 == 1) {
            if (s.charAt(n / 2) != t.charAt(n / 2)) {
                ans++;
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
