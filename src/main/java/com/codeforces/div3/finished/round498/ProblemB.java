package com.codeforces.div3.finished.round498;

import java.io.*;
import java.util.*;

public class ProblemB {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair<>(scanner.nextInt(), i));
        }
        Collections.sort(list, Comparator.comparingInt(a -> a.first));
        Collections.reverse(list);

        long s = 0;
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            indexes.add(list.get(i).second);
            s += list.get(i).first;
        }
        Collections.sort(indexes);

        int x = -1;
        out.println(s);
        for (int i = 0; i < k - 1; i++) {
            out.print((indexes.get(i) - x) + " ");
            x = indexes.get(i);
        }


        out.print(n - x - 1);



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
