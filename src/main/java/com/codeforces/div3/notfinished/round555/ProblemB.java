package com.codeforces.div3.notfinished.round555;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemB {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        String s = scanner.next();

        int[] arr = new int[10];
        for (int i = 1; i < 10; i++) {
            arr[i] = scanner.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            int x = s.charAt(i) - '0';
            if (x < arr[x]) {
                sb.append(arr[x]);
                changed = true;
            } else if (x > arr[x]) {
                if (changed) {
                    for (int j = i; j < n; j++) {
                        sb.append(s.charAt(j));
                    }
                    break;
                } else {
                    sb.append(x);
                }
            } else {
                sb.append(x);
            }
        }

        out.println(sb.toString());




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
