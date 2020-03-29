package com.codeforces.div3.round629;

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

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(scanner.nextInt());
            }
            int k = 1;
            List<Integer> ans = new ArrayList<>();
            ans.add(k);
            boolean equal = false;
            for (int i = 1; i < n; i++) {
                if (list.get(i).equals(list.get(i - 1))) {
                    equal = true;
                } else {
                    if (k == 1) {
                        k = 2;
                    } else {
                        k = 1;
                    }
                }
                if (i != n - 1) {
                    ans.add(k);
                }
            }
            if (k == 2) {
                ans.add(2);
            } else if (list.get(n - 1).equals(list.get(0))) {
                ans.add(1);
            } else if (equal) {
                k = 1;
                ans = new ArrayList<>();
                ans.add(k);
                boolean change = false;
                for (int i = 1; i < n; i++) {
                    if (!list.get(i).equals(list.get(i - 1)) || !change) {
                        if (k == 1) {
                            k = 2;
                        } else {
                            k = 1;
                        }
                        if (list.get(i).equals(list.get(i - 1))) {
                            change = true;
                        }
                    }
                    ans.add(k);
                }
            } else {
                ans.add(3);
            }

            int m = 1;
            for (int x : ans) {
                if (x > m) {
                    m = x;
                }
            }

            out.println(m);
            for (int x : ans) {
                out.print(x + " ");
            }
            out.println();
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
