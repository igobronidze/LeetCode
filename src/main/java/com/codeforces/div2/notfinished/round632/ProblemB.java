package com.codeforces.div2.notfinished.round632;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemB {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a.add(scanner.nextInt());
            }
            for (int i = 0; i < n; i++) {
                b.add(scanner.nextInt());
            }
            if (!a.get(0).equals(b.get(0))) {
                out.println("NO");
            } else {
                boolean b1 = false;
                boolean b2 = false;
                if (a.get(0) > 0) {
                    b1 = true;
                }
                if (a.get(0) < 0) {
                    b2 = true;
                }
                boolean cant = false;
                for (int i = 1; i < n; i++) {
                    if (b.get(i) > a.get(i) && !b1) {
                        cant = true;
                        break;
                    }
                    if (b.get(i) < a.get(i) && !b2) {
                        cant = true;
                        break;
                    }
                    if (a.get(i) > 0) {
                        b1 = true;
                    }
                    if (a.get(i) < 0) {
                        b2 = true;
                    }
                }
                if (cant) {
                    out.println("NO");
                } else {
                    out.println("YES");
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
