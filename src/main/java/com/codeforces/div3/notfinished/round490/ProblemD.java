package com.codeforces.div3.notfinished.round490;

import java.io.*;
import java.util.*;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        int[] remainders = new int[m];

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            list.add(x);
            remainders[x % m]++;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        int index = 1;
        for (int i = 0; i < m; i++) {
            if (i == index) {
                index = (i + 1) % m;
            }
            while (remainders[i] > n / m) {
                if (remainders[index] < n / m) {
                    if (!map.containsKey(i)) {
                        map.put(i, new ArrayList<>());
                    }
                    map.get(i).add(index);
                    remainders[i]--;
                    remainders[index]++;
                } else {
                    index++;
                    if (index == m) {
                        index = 0;
                    }
                }
            }
        }

        List<Integer> ansList = new ArrayList<>();
        long ans = 0;
        int[] indexes = new int[m];
        for (int i = 0; i < n; i++) {
            int x = list.get(i) % m;
            if (map.containsKey(x) && indexes[x] < map.get(x).size()) {
                int k = map.get(x).get(indexes[x]) - x;
                if (k < 0) {
                    k = m + map.get(x).get(indexes[x]) - x;
                }
                ans += k;
                ansList.add(list.get(i) + k);
                indexes[x]++;
            } else {
                ansList.add(list.get(i));
            }
        }


        out.println(ans);
        for (int x : ansList) {
            out.print(x + " ");
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
