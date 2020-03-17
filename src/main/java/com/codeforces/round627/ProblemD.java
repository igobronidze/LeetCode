package com.codeforces.round627;

import java.io.*;
import java.util.*;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            aList.add(scanner.nextInt());
        }
        for (int i = 0; i < n; i++) {
            bList.add(scanner.nextInt());
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(aList.get(i) - bList.get(i));
        }
        Collections.sort(list);

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            if (i == 0 || !list.get(i - 1).equals(list.get(i))) {
                treeMap.put(list.get(i), i + 1);
            }
        }

        long ans = 0;


        for (int i = 1; i < n; i++) {
            if (list.get(i) > 0) {
                Map.Entry<Integer, Integer> entry = treeMap.higherEntry(-1 * list.get(i));
                ans += (i - entry.getValue() + 1);
            }
        }

        out.println(ans);

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