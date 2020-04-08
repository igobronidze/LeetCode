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

        Rec r1 = new Rec(y2, y1, x1, x2);
        Rec r2 = new Rec(y4, y3, x3, x4);
        Rec r3 = new Rec(y6, y5, x5, x6);

        if (r2.left <= r1.left && r2.right >= r1.right && r2.top >= r1.top && r2.bottom <= r1.bottom) {
            out.println("NO");
            out.flush();
            return;
        }

        if (r3.left <= r1.left && r3.right >= r1.right && r3.top >= r1.top && r3.bottom <= r1.bottom) {
            out.println("NO");
            out.flush();
            return;
        }

        if (r2.right < r3.left && r1.left < r3.left) {
            out.println("YES");
            out.flush();
            return;
        }
        if (r3.right < r2.left && r1.left < r2.left) {
            out.println("YES");
            out.flush();
            return;
        }
        if (r2.bottom > r3.top && r1.top > r3.top) {
            out.println("YES");
            out.flush();
            return;
        }
        if (r3.bottom > r2.top && r1.top > r2.top) {
            out.println("YES");
            out.flush();
            return;
        }

        if ((r1.top > r2.top || r1.right > r2.right) && (r1.top > r3.top || r1.right > r3.right)) {
            out.println("YES");
            out.flush();
            return;
        }
        if ((r1.top > r2.top || r1.left < r2.left) && (r1.top > r3.top || r1.left < r3.left)) {
            out.println("YES");
            out.flush();
            return;
        }
        if ((r1.bottom < r2.bottom || r1.right > r2.right) && (r1.bottom < r3.bottom || r1.right > r3.right)) {
            out.println("YES");
            out.flush();
            return;
        }
        if ((r1.bottom < r2.bottom || r1.left < r2.left) && (r1.bottom < r3.bottom || r1.left < r3.left)) {
            out.println("YES");
            out.flush();
            return;
        }

        out.println("NO");




        out.flush();
    }

    private static class Rec {

        private int top;

        private int bottom;

        private int left;

        private int right;

        private Rec(int top, int bottom, int left, int right) {
            this.top = top;
            this.bottom = bottom;
            this.left = left;
            this.right = right;
        }
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
