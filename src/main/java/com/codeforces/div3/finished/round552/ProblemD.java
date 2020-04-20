package com.codeforces.div3.finished.round552;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int b = scanner.nextInt();
        int a = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            list.add(x);
        }

        int ans = 0;
        int maxB = b;
        int maxA = a;
        for (int i = 0; i < n; i++) {
            if (a == 0 & b == 0) {
                break;
            }
            if (list.get(i) == 0) {
                if (a == 0) {
                    b--;
                } else {
                    a--;
                }
            } else {
                if (a == maxA) {
                    a--;
                } else {
                    if (b == 0) {
                        a--;
                    } else {
                        b--;
                        a++;
                    }
                }
            }
            ans = i;
        }

        out.println(ans + 1);



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
