package com.codeforces.round501;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemB {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        String s = scanner.next();
        String t = scanner.next();

        boolean cant = false;

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == t.charAt(i)) {
                continue;
            }
            int k = -1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) == t.charAt(i)) {
                    k = j;
                    break;
                }
            }
            if (k == -1) {
                cant = true;
                break;
            }
            for (int j = k; j >= i + 1; j--) {
                ans.add(j);
            }
            s = s.substring(0, i) + s.charAt(k) + s.substring(i, k) + s.substring(k + 1);
        }

        if (cant) {
            out.print(-1);
        } else {
            out.println(ans.size());
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

        public Pair() {}

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
