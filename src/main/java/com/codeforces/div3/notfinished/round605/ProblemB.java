package com.codeforces.div3.notfinished.round605;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemB {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            String s = scanner.next();
            int x = 0;
            int y = 0;
            int a = 0;
            int b = 0;
            for (char c : s.toCharArray()) {
                if (c == 'L') {
                    x++;
                } else if (c == 'R') {
                    y++;
                } else if (c == 'U') {
                    a++;
                } else {
                    b++;
                }
            }
            int k = Math.min(x, y);
            int d = Math.min(a, b);
            if (k == 0 && d == 0) {
                out.println(0);
                out.println();
            } else if (k == 0) {
                out.println(2);
                out.println("UD");
            } else if (d == 0) {
                out.println(2);
                out.println("LR");
            } else {
                out.println((k + d) * 2);
                for (int i = 0; i < Math.min(x, y); i++) {
                    out.print("L");
                }
                for (int i = 0; i < Math.min(a, b); i++) {
                    out.print("U");
                }
                for (int i = 0; i < Math.min(x, y); i++) {
                    out.print("R");
                }
                for (int i = 0; i < Math.min(a, b); i++) {
                    out.print("D");
                }
                out.println();
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
