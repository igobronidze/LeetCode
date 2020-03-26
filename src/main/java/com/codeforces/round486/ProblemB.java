package com.codeforces.round486;

import java.io.*;
import java.util.*;

public class ProblemB {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.next());
        }

        list.sort(Comparator.comparingInt(String::length));

        for (int i = 1; i < n; i++) {
            if (!isSubs(list.get(i - 1), list.get(i))) {
                out.println("NO");
                out.flush();
                return;
            }
        }

        out.println("YES");
        for (String s : list) {
            out.println(s);
        }


        out.flush();
    }

    private static boolean isSubs(String a, String b) {
        for (int i = 0; i <= b.length() - a.length(); i++) {
            if (a.equals(b.substring(i, i + a.length()))) {
                return true;
            }
        }
        return false;
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
