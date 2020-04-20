package com.codeforces.div3.finished.round490;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String s = scanner.next();

        int[] cc = new int['z' + 1];

        for (int i = 0; i < n; i++) {
            cc[s.charAt(i)]++;
        }

        int ind = 'a' - 1;
        int sum = 0;
        int x = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            sum += cc[i];
            if (k < sum) {
                x = sum - k;
                break;
            } else {
                ind = i;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ind + 1) {
                if (x > 0) {
                    ans.append(s.charAt(i));
                    x--;
                }
            } else if (s.charAt(i) > ind + 1) {
                ans.append(s.charAt(i));
            }
        }

        for (int i = ans.length() - 1; i >= 0; i--) {
            out.print(ans.charAt(i));
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
