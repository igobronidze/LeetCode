package com.codeforces.div3.finished.round611;

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

        Set<Integer> trees = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            trees.add(x);
            list1.add(x);
            list2.add(x);
        }

        Set<Integer> ans = new HashSet<>();
        boolean finished = false;
        while (true) {
            List<Integer> tmpList1 = new ArrayList<>();
            List<Integer> tmpList2 = new ArrayList<>();
            for (int x : list1) {
                if (!ans.contains(x - 1) && !trees.contains(x - 1)) {
                    ans.add(x - 1);
                    tmpList1.add(x - 1);
                }
                if (ans.size() == m) {
                    finished = true;
                    break;
                }
            }
            if (finished) {
                break;
            }
            for (int x : list2) {
                if (!ans.contains(x + 1) && !trees.contains(x + 1)) {
                    ans.add(x + 1);
                    tmpList2.add(x + 1);
                }
                if (ans.size() == m) {
                    finished = true;
                    break;
                }
            }
            list1 = tmpList1;
            list2 = tmpList2;
            if (finished) {
                break;
            }
        }

        long s = 0;
        TreeSet<Integer> treeSet = new TreeSet<>(trees);
        for (int x : ans) {
            s += getDistance(treeSet, x);
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
