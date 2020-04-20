package com.codeforces.div3.finished.round575;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int b = scanner.nextInt();
            int w = scanner.nextInt();
            if (b > w) {
                if (w * 3 + 1 < b) {
                    out.println("NO");
                } else {
                    out.println("YES");
                    for (int i = 1; i <= 2 * w; i += 2) {
                        out.println(i + " 2");
                        out.println((i + 1) + " 2");
                    }
                    b = b - w;
                    for (int i = 2; i <= 2 * w; i += 2) {
                        if (b == 0) {
                            break;
                        }
                        out.println(i + " 1");
                        b--;
                        if (b == 0) {
                            break;
                        }
                        out.println(i + " 3");
                        b--;
                    }
                    if (b > 0) {
                        out.println((w * 2 + 1) + " 2");
                    }
                }
            } else {
                if (b * 3 + 1 < w) {
                    out.println("NO");
                } else {
                    out.println("YES");
                    for (int i = 1; i <= 2 * b; i += 2) {
                        out.println(i + " 3");
                        out.println((i + 1) + " 3");
                    }
                    w = w - b;
                    for (int i = 2; i <= 2 * b; i += 2) {
                        if (w == 0) {
                            break;
                        }
                        out.println(i + " 2");
                        w--;
                        if (w == 0) {
                            break;
                        }
                        out.println(i + " 4");
                        w--;
                    }
                    if (w > 0) {
                        out.println((b * 2 + 1) + " 3");
                    }
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

        public Pair() {
        }

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }

    private static class Triple<F, S, T> {

        private F first;

        private S second;

        private T third;

        public Triple() {
        }

        public Triple(F first, S second, T third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}
