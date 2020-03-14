package com.codeforces.round615;

import java.io.*;
import java.util.*;

public class ProblemB {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();

            Map<Integer, List<Integer>> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if (!map.containsKey(x)) {
                    map.put(x, new ArrayList<>());
                }
                map.get(x).add(y);
            }

            StringBuilder ans = new StringBuilder();

            boolean b = false;
            int j = 0;
            int c = 0;
            for (int i = 0; i <= 1000; i++) {
                if (map.containsKey(i)) {
                    List<Integer> list = map.get(i);
                    Collections.sort(list);
                    if (list.get(0) < j) {
                        b = true;
                        break;
                    } else {
                        for (int q = 0; q < (list.get(list.size() - 1) - j); q++) {
                            ans.append("U");
                        }
                        j = list.get(list.size() - 1);
                    }
                    c++;
                    if (c == map.size()) {
                        break;
                    }
                    ans.append("R");
                } else {
                    ans.append("R");
                }
            }

            if (b) {
                out.println("NO");
            } else {
                out.println("YES");
                out.println(ans.toString());
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
