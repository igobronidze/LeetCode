package com.codeforces.div3.notfinished.round587;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1; i < 1000000; i++) {
            list.add(list.get(i - 1) + Integer.toString(i).length());
        }

        List<Long> sum = new ArrayList<>();
        sum.add(1L);
        for (int i = 1; i < list.size(); i++) {
            sum.add(sum.get(i - 1) + list.get(i));
        }

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            long x = scanner.nextLong();
            if (x == 1L) {
                out.println(1);
            } else {
                for (int j = 1; j < sum.size(); j++) {
                    if (sum.get(j) <= x && sum.get(j + 1) > x) {
                        long y = x - sum.get(j - 1);
                        long s = 0;
                        int k = 1;
                        while (true) {
                            String kStr = Integer.toString(k);
                            if (s + kStr.length() >= y) {
                                long p = y - s;
                                out.println(kStr.charAt((int)p - 1));
                                break;
                            } else {
                                s = s + kStr.length();
                            }
                            k++;
                        }
                        break;
                    }
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

        public Pair() {
        }

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}