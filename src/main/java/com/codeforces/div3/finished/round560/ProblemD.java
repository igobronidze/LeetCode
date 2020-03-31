package com.codeforces.div3.finished.round560;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int q = 0; q < t; q++) {
            int n = scanner.nextInt();
            List<Long> list = new ArrayList<>();
            for (int i = 0; i < n ; i++) {
                list.add(scanner.nextLong());
            }
            Collections.sort(list);

            long x = list.get(0) * list.get(n - 1);
            boolean cant = false;
            for (int i = 0; i < n; i++) {
                if (list.get(i) * list.get(n - i - 1) != x) {
                    cant = true;
                    break;
                }
            }
            if (cant) {
                out.println(-1);
            } else {
                int c = 0;
                for (int i = 2; i <= Math.sqrt(x); i++) {
                    if (x % i == 0) {
                        if (i == x / i) {
                            c++;
                        } else {
                            c += 2;
                        }
                    }
                }
                if (c == n) {
                    out.println(x);
                } else {
                    out.println(-1);
                }
            }
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
