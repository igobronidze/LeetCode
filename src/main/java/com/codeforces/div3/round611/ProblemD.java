package com.codeforces.div3.round611;

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
        TreeSet<Integer> trees = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            trees.add(scanner.nextInt());
        }

        int k = solve(trees, 0, m / 2 + 1, m);

        Set<Integer> ans = new HashSet<>();
        long s = 0;

        k--;
        int last = Integer.MIN_VALUE;
        for (int x : trees) {
            for (int i = Math.max(last, x - k); i <= x + k; i++) {
                if (!trees.contains(i)) {
                    ans.add(i);
                    s += getDistance(trees, i);
                }
            }
            last = x + k + 1;
        }

        k++;
        for (int x : trees) {
            if (ans.size() == m) {
                break;
            }
            int p = x - k;
            int q = x + k;
            if (!trees.contains(p) && !ans.contains(p)) {
                ans.add(p);
                s += k;
                if (ans.size() == m) {
                    break;
                }
            }
            if (!trees.contains(q) && !ans.contains(q)) {
                ans.add(q);
                s += k;
            }
        }


        out.println(s);
        for (int x : ans) {
            out.print(x + " ");
        }


        out.flush();
    }

    private static int getDistance(TreeSet<Integer> trees, int x) {
        Integer a = trees.lower(x);
        Integer b = trees.higher(x);
        if (a == null) {
            return Math.abs(b - x);
        } else if (b == null ){
            return Math.abs(a - x);
        } else {
            return Math.min(Math.abs(a - x), Math.abs(b - x));
        }
    }

    private static int solve(TreeSet<Integer> trees, int l, int r, int m) {
        if (l == r) {
            return r;
        }
        if (l + 1 == r) {
            if (cover(trees, l, m)) {
                return l;
            } else {
                return r;
            }
        }
        int mid = (l + r) / 2;
        if (cover(trees, mid, m)) {
            return solve(trees, l, mid, m);
        } else {
            return solve(trees, mid + 1, r, m);
        }
    }

    private static boolean cover(TreeSet<Integer> trees, int k, int m) {
        Set<Integer> set = new HashSet<>();
        int last = Integer.MIN_VALUE;
        Integer p = 0;
        for (int x : trees) {
            if (p != null && p == 0) {
                p = x;
            }
            for (int i = Math.max(last, x - k); i <= x + k; i++) {
                if (p == null) {
                    set.add(i);
                    if (set.size() == m) {
                        return true;
                    }
                } else {
                    if (p == i) {
                        p = trees.higher(p);
                    } else {
                        set.add(i);
                        if (set.size() == m) {
                            return true;
                        }
                    }
                }
            }
            last = x + k + 1;
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

        public Pair() {
        }

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
