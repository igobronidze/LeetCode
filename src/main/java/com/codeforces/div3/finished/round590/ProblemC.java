package com.codeforces.div3.finished.round590;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            String s1 = "1" + scanner.next() + "1";
            String s2 = "1" + scanner.next() + "1";

            int i = 0, j = 0;
            boolean cant = false;
            boolean changedLine = false;
            while (true) {
                if (i == n + 1 && j == 1) {
                    break;
                } else if (i == n + 1) {
                    cant = true;
                    break;
                }

                char c = (j == 0) ? s1.charAt(i) : s2.charAt(i);

                if (c == '1' || c == '2') {
                    if (changedLine) {
                        cant = true;
                        break;
                    } else {
                        i++;
                        changedLine = false;
                    }
                } else {
                    if (changedLine) {
                        i++;
                        changedLine = false;
                    } else {
                        j = (j + 1) % 2;
                        changedLine = true;
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
