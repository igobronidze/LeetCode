package com.codeforces.div3.notfinished.round540;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemB {

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

        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        pairs.add(new Pair<>(list.get(0), 0));
        for (int i = 1; i < n; i++) {
            if (i % 2 == 1) {
                pairs.add(new Pair<>(pairs.get(i - 1).first, pairs.get(i - 1).second + list.get(i)));
            } else {
                pairs.add(new Pair<>(pairs.get(i - 1).first + list.get(i), pairs.get(i - 1).second));
            }
        }

        int ans = 0;
        int x = 0, y = 0;
        for (int i = n - 1; i > 0; i--) {
            if (x + pairs.get(i - 1).first == y + pairs.get(i - 1).second) {
                ans++;
            }
            if (n % 2 == 0) {
                if (i % 2 == 0) {
                    y += list.get(i);
                } else {
                    x += list.get(i);
                }
            } else {
                if (i % 2 == 0) {
                    y += list.get(i);
                } else {
                    x += list.get(i);
                }
            }
        }
        if (x == y) {
            ans++;
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
