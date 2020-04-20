package com.codeforces.div3.notfinished.round540;

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
        int m = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            list.add(x);
        }
        Collections.sort(list);
        Collections.reverse(list);

        if (canSolve(list, n, m)) {
            out.println(binarySearch(list, 1, n, m));
        } else {
            out.println(-1);
        }


        out.flush();
    }

    private static int binarySearch(List<Integer> list, int l, int r, int m) {
        if (l == r) {
            return l;
        }
        if (l + 1 == r) {
            if (canSolve(list, l, m)) {
                return l;
            } else {
                return r;
            }
        }
        int mid = (l + r) / 2;
        if (canSolve(list, mid, m)) {
            return binarySearch(list, l, mid, m);
        } else {
            return binarySearch(list, mid + 1, r, m);
        }
    }

    private static boolean canSolve(List<Integer> list, int d, int m) {
        int k = -1;
        int s = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i % d == 0) {
                k++;
            }
            if (list.get(i) <= k) {
                return false;
            }
            s = s + list.get(i) - k;
            if (s >= m) {
                return true;
            }
        }
        return false;
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
