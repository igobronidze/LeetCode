package com.codeforces.div3.finished.round579;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ProblemD_2 {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        String s = scanner.next();
        String t = scanner.next();

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            while (true) {
                if (t.charAt(i) == s.charAt(j)) {
                    j++;
                    map.put(i + 1, j);
                    break;
                } else {
                    j++;
                }
            }
        }

        s = reverse(s);
        t = reverse(t);
        j = 0;
        int ans = s.length() - map.get(t.length());
        for (int i = 0; i < t.length(); i++) {
            while (true) {
                if (t.charAt(i) == s.charAt(j)) {
                    j++;
                    ans = Math.max(ans, s.length() - j - map.get(t.length() - i - 1));
                    break;
                } else {
                    j++;
                }
            }
        }



        out.println(ans);



        out.flush();
    }

    private static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
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
