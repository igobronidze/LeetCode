package com.codeforces.div2.notfinished.round613;

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
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        out.println(solve(list, 30));


        out.flush();
    }

    private static int solve(List<Integer> list, int index) {
        if (index == -1) {
            return 0;
        }
        List<Integer> zeros = new ArrayList<>();
        List<Integer> ones = new ArrayList<>();
        for (int x : list) {
            if ((x & (1 << index)) == 0) {
                zeros.add(x);
            } else {
                ones.add(x);
            }
        }

        if (zeros.isEmpty()) {
            return solve(ones, index - 1);
        } else if (ones.isEmpty()) {
            return solve(zeros, index - 1);
        }

        int x = (1 << index) + solve(ones, index - 1);
        int y = (1 << index) + solve(zeros, index - 1);


        return Math.min(x, y);
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
