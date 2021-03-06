package com.codeforces.div3.notfinished.round555;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> ans = new ArrayList<>();
        long s = 0;
        for (int i = 1; i <= k; i++) {
            s = s + i;
            ans.add(i);
        }
        if (s > n) {
            out.println("NO");
        } else {
            n = n - (int) s;
            for (int i = 0; i < k; i++) {
                ans.set(i, ans.get(i) + n / k);
            }
            n = n % k;
            for (int i = k - 1; i > 0; i--) {
                if (n == 0) {
                    break;
                }
                if (ans.get(i) + 1 > ans.get(i - 1) * 2) {
                    break;
                }
                ans.set(i, ans.get(i) + 1);
                n--;
            }
            for (int i = k - 1; i > 0; i--) {
                if (n == 0) {
                    break;
                }
                if (ans.get(i) + 1 > ans.get(i - 1) * 2) {
                    break;
                }
                ans.set(i, ans.get(i) + 1);
                n--;
            }
            if (n > 0) {
                out.println("NO");
            } else {
                out.println("YES");
                for (int x : ans) {
                    out.print(x + " ");
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
}
