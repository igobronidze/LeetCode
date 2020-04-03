package com.codeforces.div3.finished.round547;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            list.add(scanner.nextInt());
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        for (int i = 0; i < n - 1; i++) {
            ans.add(ans.get(ans.size() - 1) + list.get(i));
        }

        int min = Integer.MAX_VALUE;
        for (int x : ans) {
            min = Math.min(min, x);
        }

        boolean[] used = new boolean[n + 1];
        boolean cant = false;
        for (int i = 0; i < n; i++) {
            int x = ans.get(i) + (1 - min);
            if (x < 0 || x > n || used[x]) {
                cant = true;
                break;
            }
            ans.set(i, x);
            used[x] = true;
        }

        if (cant) {
            out.print(-1);
        } else {
            for (int x : ans) {
                out.print(x + " ");
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

        public Pair() {
        }

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
