package com.codeforces.div3.finished.round590;

import java.io.*;
import java.util.*;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        String s = scanner.next();

        int n = s.length();
        int[] masksSet = new int[1 << 20 + 1];
        int[] dp = new int[(1 << 20) + 1];
        for (int i = 0; i < n; i++) {
            int mask = 0;
            for (int j = i; j >= 0; j--) {
                int x = 1 << (s.charAt(j) - 'a');
                int y = mask ^ x;
                if (y > mask) {
                    mask = y;
                } else {
                    break;
                }
                masksSet[mask] = 1;
            }
        }

        for (int i = 0; i < masksSet.length; i++) {
            if (masksSet[i] == 1) {
                dp[i] = getOnesCount(i);
            }
        }

        for (int i = 1; i <= (1 << 20); i++) {
            int len = Integer.toBinaryString(i).length();
            for (int j = 0; j < len; j++) {
                int x = i ^ (1 << j);
                if (x < i) {
                    dp[i] = Math.max(dp[i], dp[x]);
                }
            }
        }

        int max = (1 << 20) - 1;

        int ans = 0;
        for (int i = 0; i < masksSet.length; i++) {
            if (masksSet[i] == 1) {
                int x = i ^ max;
                ans = Math.max(ans, getOnesCount(i) + dp[x]);
            }
        }

        out.println(ans);



        out.flush();
    }

    private static int getOnesCount(int x) {
        String bin = Integer.toBinaryString(x);
        int s = 0;
        for (char c : bin.toCharArray()) {
            if (c == '1') {
                s++;
            }
        }
        return s;
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
