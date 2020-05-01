package com.codeforces.educational.educational_86;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sizes.add(scanner.nextInt());
        }
        Collections.sort(sizes);
        Collections.reverse(sizes);

        int[] maxNums = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            int x = scanner.nextInt();
            maxNums[i] = x;
        }
        for (int i = 2; i <= k; i++) {
            maxNums[i] = Math.min(maxNums[i], maxNums[i - 1]);
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sizes.get(i);
            if (maxNums[x] <= list.size()) {
                ans.add(list);
                list = new ArrayList<>();
            }
            list.add(sizes.get(i));
        }
        ans.add(list);

        out.println(ans.size());
        for (List<Integer> ansList : ans) {
            out.print(ansList.size() + " ");
            for (int x : ansList) {
                out.print(x + " ");
            }
            out.println();
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
