package com.codeforces.div3.notfinished.round587;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        int x4 = scanner.nextInt();
        int y4 = scanner.nextInt();
        int x5 = scanner.nextInt();
        int y5 = scanner.nextInt();
        int x6 = scanner.nextInt();
        int y6 = scanner.nextInt();

        if (x1 < x3 && x1 < x5) {
            out.println("YES");
        } else if (x2 > x4 && x2 > x6) {
            out.println("YES");
        } else if (y1 < y3 && y1 < y5) {
            out.println("YES");
        } else if (y2 > y4 && y2 > y6) {
            out.println("YES");
        } else {
            if (x4 > x6 && x3 > x6) {
                out.println("YES");
            } else if (x6 > x4 && x5 > x4) {
                out.println("YES");
            } else if (y4 > y6 && y3 > y6) {
                out.println("YES");
            } else if (y6 > y4 && y5 > y4) {
                out.println("YES");
            } else {
                out.println("NO");
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
