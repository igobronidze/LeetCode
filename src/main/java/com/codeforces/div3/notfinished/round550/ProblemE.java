package com.codeforces.div3.notfinished.round550;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        String s = scanner.next();
        String t = scanner.next();

        int m = 'z' - 'a' + 1;

        List<Integer> first = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            first.add(s.charAt(i) - 'a');
        }
        List<Integer> second = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            second.add(t.charAt(i) - 'a');
        }

        List<Integer> sum = new ArrayList<>();
        int x = 0;
        for (int i = n - 1; i >= 0; i--) {
            x += first.get(i) + second.get(i);
            if (x >= m) {
                sum.add(x % m);
                x = 1;
            } else {
                sum.add(x);
                x = 0;
            }
        }
        if (x != 0) {
            sum.add(x);
        }
        Collections.reverse(sum);

        List<Integer> ans = new ArrayList<>();
        x = 0;
        if (sum.size() == n) {
            x = 0;
        } else {
            x = m;
        }
        for (int i = sum.size() == n ? 0 : 1; i < sum.size(); i++) {
            x += sum.get(i);
            ans.add(x / 2);
            x = m * (x % 2);
        }

        for (int i = 0; i < ans.size(); i++) {
            out.print((char)(ans.get(i) + 'a'));
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
