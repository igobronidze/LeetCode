package com.codeforces.other.global_7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    private static final int mod = 998244353;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            list.add(scanner.nextInt());
        }

        if (k == 1) {
            out.println(n);
            out.println(1);
        } else {
            int x = -1;
            long ans = 1;
            for (int i = 0; i < n ; i++) {
                if (list.get(i) > n - k) {
                    if (x != -1) {
                        ans = ans * (i - x) % mod;
                    }
                    x = i;
                }
            }

            long p = 0;
            for (int i = n - k + 1; i <= n; i++) {
                p += i;
            }

            out.println(p);
            out.println(ans);
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
}
