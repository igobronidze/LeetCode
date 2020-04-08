package com.codeforces.div3.notfinished.round494;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int k = scanner.nextInt();

        if (d >= n) {
            out.println("NO");
        } else {
            if (n == 1) {
                if (k == 1) {
                    out.println("YES");
                } else {
                    out.println("NO");
                }
            } else {
                if (k == 1) {
                    if (n == 2) {
                        out.println("YES");
                        out.println("1 2");
                    } else {
                        out.println("NO");
                    }
                } else {
                    LinkedList<Triple<Integer, Integer, Integer>> nodes = new LinkedList<>();
                    List<Pair<Integer, Integer>> ans = new ArrayList<>();
                    for (int i = 2; i <= d + 1; i++) {
                        nodes.add(new Triple<>(i, 2, Math.min(d - i + 1, i - 1)));
                        ans.add(new Pair<>(i - 1, i));
                    }

                    int p = d + 2;

                    boolean cant = false;
                    while (p <= n) {
                        if (nodes.isEmpty()) {
                            cant = true;
                            break;
                        }
                        Triple<Integer, Integer, Integer> node = nodes.poll();
                        if (node.third > 0) {
                            for (int i = node.second; i < k; i++) {
                                nodes.add(new Triple<>(p, 1, node.third - 1));
                                ans.add(new Pair<>(node.first, p++));
                                if (p == n + 1) {
                                    break;
                                }
                            }
                        }
                    }

                    if (cant) {
                        out.println("NO");
                    } else {
                        out.println("YES");
                        for (Pair<Integer, Integer> pair : ans) {
                            out.println(pair.first + " " + pair.second);
                        }
                    }
                }
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
