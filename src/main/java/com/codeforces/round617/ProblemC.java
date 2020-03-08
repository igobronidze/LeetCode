package com.codeforces.round617;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            String s = scanner.next();
            Map<Pair, Integer> map = new HashMap<>();
            int x = 0, y = 0;
            int a = 0, b = 0, min = Integer.MAX_VALUE;
            map.put(new Pair(0, 0), 0);
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'L') {
                    x--;
                }
                if (s.charAt(i) == 'R') {
                    x++;
                }
                if (s.charAt(i) == 'D') {
                    y--;
                }
                if (s.charAt(i) == 'U') {
                    y++;
                }
                Pair pair = new Pair(x, y);
                if (map.containsKey(pair)) {
                    if (i - map.get(pair) < min) {
                        min = i - map.get(pair);
                        a = map.get(pair);
                        b = i;
                    }
                }
                map.put(pair, i + 1);
            }
            if (min == Integer.MAX_VALUE) {
                out.println(-1);
            } else {
                out.println((a + 1) + " " + (b + 1));
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

    private static class Pair {

        private Integer first;

        private Integer second;

        public Pair() {}

        public Pair(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(first, pair.first) &&
                    Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
}
