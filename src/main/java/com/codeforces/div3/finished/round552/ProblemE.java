package com.codeforces.div3.finished.round552;

import java.io.*;
import java.util.*;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Integer> list = new LinkedList<>();
        List<Pair<Integer, Integer>> path = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            list.add(x);
            map.put(x, i);
            path.add(new Pair<>());
            if (i != 0) {
                path.get(i).first = i - 1;
            }
            if (i != n - 1) {
                path.get(i).second = i + 1;
            }
        }

        int[] ans = new int[n + 1];
        int p = 1;

        for (int i = n; i >= 1; i--) {
            int ind = map.get(i);
            if (ans[ind] == 0) {
                ans[ind] = p;
                Integer left = path.get(ind).first;
                for (int j = 0; j < k; j++) {
                    if (left == null) {
                        break;
                    } else {
                        ans[left] = p;
                        left = path.get(left).first;
                    }
                }

                Integer right = path.get(ind).second;
                for (int j = 0; j < k; j++) {
                    if (right == null) {
                        break;
                    } else {
                        ans[right] = p;
                        right = path.get(right).second;
                    }
                }
                if (left != null) {
                    path.get(left).second = right;
                }
                if (right != null) {
                    path.get(right).first = left;
                }

                p = p % 2 + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            out.print(ans[i]);
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
