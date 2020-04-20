package com.codeforces.educational.educational_85;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemA {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            List<Pair<Integer, Integer>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new Pair<>(scanner.nextInt(), scanner.nextInt()));
            }

            boolean cant = false;
            for (int i = 0; i < n; i++) {
                Pair<Integer, Integer> pair = list.get(i);
                if (pair.second > pair.first) {
                    cant = true;
                }
                if (i != 0) {
                    Pair<Integer, Integer> last = list.get(i - 1);
                    if (pair.first < last.first) {
                        cant = true;
                    }
                    if (pair.second < last.second) {
                        cant = true;
                    }
                    if (pair.first - last.first < pair.second - last.second) {
                        cant = true;
                    }
                }
            }
            if (cant) {
                out.println("NO");
            } else {
                out.println("YES");
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
