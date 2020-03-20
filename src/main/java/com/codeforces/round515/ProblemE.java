package com.codeforces.round515;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    private static final int mod = 998244353;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String a = scanner.next();
        String b = scanner.next();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.abs(n - m); i++) {
            sb.append("0");
        }
        if (n > m) {
            b = sb.toString() + b;
        } else {
            a = sb.toString() + a;
        }

        List<Long> powers = new ArrayList<>();
        long x = 1;
        for (int i = 0; i < a.length(); i++) {
            powers.add(x);
            x = (x * 2) % mod;
        }
        Collections.reverse(powers);

        int[] dp = new int[a.length()];
        if (b.charAt(0) == '1') {
            dp[0] = 1;
        }
        for (int i = 1; i < b.length(); i++) {
            if (b.charAt(i) == '1') {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }

        long ans = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '1') {
                ans = (ans + powers.get(i) * dp[i] % mod) % mod;
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

        public Pair() {
        }

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
