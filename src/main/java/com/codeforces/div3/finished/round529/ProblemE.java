package com.codeforces.div3.finished.round529;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        String s = scanner.next();
        List<Integer> list = new ArrayList<>();
        if (n % 2 == 0) {
            int x = 0;
            int k = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (s.charAt(i) == ')') {
                    x++;
                } else {
                    x--;
                }
                if (x < 0 && k == -1) {
                    k = i;
                }
                list.add(x);
            }
            Collections.reverse(list);

            x = 0;
            int y;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '(') {
                    x++;
                    y = x - 2;
                } else {
                    x--;
                    y = x + 2;
                }
                if (y >= 0) {
                    if (i == n - 1) {
                        if (y == 0) {
                            ans++;
                        }
                    } else {
                        if (list.get(i + 1) == y && i >= k) {
                            ans++;
                        }
                    }

                }
                if (x < 0) {
                    break;
                }
            }
            out.println(ans);
        } else {
            out.println(0);
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
