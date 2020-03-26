package com.codeforces.div3.round611;

import java.io.*;
import java.util.*;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);


        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        boolean[] b = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            list.add(x);
            b[x] = true;
        }

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (!b[i]) {
                linkedList.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        int last = 0;
        for (int i = 0; i < n; i++) {
            if (list.get(i) != 0) {
                ans.add(list.get(i));
            } else {
                int x = 0;
                if (linkedList.getFirst() == i + 1) {
                    x = linkedList.removeLast();
                } else {
                    x = linkedList.removeFirst();
                }
                ans.add(x);
                if (linkedList.isEmpty()) {
                    if (x == i + 1) {
                        int tmp = ans.get(last);
                        ans.set(last, x);
                        ans.set(i, tmp);
                    }
                }
                last = i;
            }
        }

        for (int x : ans) {
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

        public Pair() {
        }

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
