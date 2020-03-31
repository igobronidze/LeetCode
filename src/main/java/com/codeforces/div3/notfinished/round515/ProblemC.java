package com.codeforces.div3.notfinished.round515;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int q = scanner.nextInt();

        Pair<Integer, Integer>[] pairs = new Pair[200002];
        int l = 0;
        int r = 0;
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < q; i++) {
            String command = scanner.next();
            int x = scanner.nextInt();

            switch (command) {
                case "L" :
                    l++;
                    map.put(x, "L");
                    pairs[x] = new Pair<>(l, r);
                    break;
                case "R":
                    r++;
                    map.put(x, "R");
                    pairs[x] = new Pair<>(l, r);
                    break;
                case "?":
                    int a = l - pairs[x].first;
                    int b = r - pairs[x].second;
                    if (map.get(x).equals("L")) {
                        out.println(Math.min(a, (l + r - a - 1)));
                    } else {
                        out.println(Math.min(b, (l + r - b - 1)));
                    }
                    break;
            }
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
