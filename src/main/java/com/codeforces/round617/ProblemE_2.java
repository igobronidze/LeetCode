package com.codeforces.round617;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemE_2 {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        String s = scanner.next();

        int[] arr = new int[200];
        int[] ans = new int[n + 1];


        int mmm = 0;
        for (int i = 0; i < n; i++) {
            int m = 0;
            for (int k = s.charAt(i) + 1; k <= 'z'; k++) {
                m = Math.max(m, arr[k]);
            }
            arr[s.charAt(i)] = m + 1;
            ans[i] = m + 1;
            mmm = Math.max(mmm, m + 1);
        }

        out.println(mmm);
        for (int i = 0; i < n; i++) {
            out.print(ans[i] + " ");
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
