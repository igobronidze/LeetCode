package com.codeforces.div3.finished.round560;

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
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextInt());
        }
        for (int i = 0; i < n; i++) {
            b.add(scanner.nextInt());
        }

        int mod = 998244353;

        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long x = a.get(i);
            x = x * (i + 1);
            x = x * (n - i);
            list.add(x);
        }
        Collections.sort(list);
        Collections.sort(b);
        Collections.reverse(b);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (list.get(i) % mod) * b.get(i)) % mod;
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
}
