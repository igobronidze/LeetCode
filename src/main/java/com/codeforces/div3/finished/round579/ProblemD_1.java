package com.codeforces.div3.finished.round579;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemD_1 {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        String s = scanner.next();
        String t = scanner.next();

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String str = s.substring(0, i) + s.substring(j + 1);
                if (isSubSeq(str, t)) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        out.println(ans);


        out.flush();
    }

    private static boolean isSubSeq(String s, String t) {
        int j = 0;
        int x = 0;
        if (t.equals("")) {
            return true;
        }
        if (s.equals("")) {
            return false;
        }
        for (int i = 0; i < t.length(); i++) {
            while (true) {
                if (t.charAt(i) == s.charAt(j)) {
                    x++;
                    j++;
                    break;
                }
                j++;
                if (j == s.length()) {
                    break;
                }
            }
            if (j == s.length()) {
                break;
            }
        }
        return x == t.length();
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
