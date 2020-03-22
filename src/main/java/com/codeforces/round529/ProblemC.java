package com.codeforces.round529;

import java.io.*;
import java.util.*;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        if (k > n) {
            out.println("NO");
        } else {
            String s = Integer.toBinaryString(n);
            long x = 1;
            LinkedList<Integer> powers = new LinkedList<>();
            while (x <= n) {
                powers.add((int)x);
                x = x * 2;
            }
            List<Integer> ans = new ArrayList<>();
            boolean cant = false;
            while (n != 0) {
                if (k == 0) {
                    cant = true;
                    break;
                }
                if (n - powers.getLast() >= k - 1) {
                    ans.add(powers.getLast());
                    n -= powers.getLast();
                    k--;
                } else {
                    powers.removeLast();
                }
            }

            if (cant) {
                out.println("NO");
            } else {
                out.println("YES");
                for (int a : ans) {
                    out.print(a + " ");
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
