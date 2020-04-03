package com.codeforces.div3.finished.round547;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        long h = scanner.nextLong();
        int n = scanner.nextInt();
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLong() * -1);
        }

        long s = 0;
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            s = s + list.get(i);
            if (s >= h) {
                out.println(i + 1);
                out.flush();
                return;
            }
            max = Math.max(max, s);
        }
        if (s > 0) {

            long x = h - max;
            long ans = x % s == 0 ? x / s : x / s + 1;

            s = ans * s;
            ans = ans * n;

            for (int i = 0; i < n; i++) {
                s = s + list.get(i);
                if (s >= h) {
                    out.println(ans + i + 1);
                    out.flush();
                    return;
                }
            }
        } else {
            out.println(-1);
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
