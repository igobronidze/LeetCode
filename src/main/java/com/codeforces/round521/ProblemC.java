package com.codeforces.round521;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            sum += x;
            list.add(x);
        }

        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        int max1 = sortedList.get(n - 1);
        int max2 = sortedList.get(n - 2);

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long x = sum - list.get(i);
            if (list.get(i) == max1) {
                if (2L * max2 == x) {
                    ans.add(i + 1);
                }
            } else {
                if (2L * max1 == x) {
                    ans.add(i + 1);
                }
            }
        }

        out.println(ans.size());
        for (int i = 0; i < ans.size(); i++) {
            out.print(ans.get(i) + " ");
        }
        out.println();


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
