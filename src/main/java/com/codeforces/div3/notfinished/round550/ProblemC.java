package com.codeforces.div3.notfinished.round550;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int[] count = new int[200007];
        List<Integer> list = new ArrayList<>();
        boolean cant = false;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            list.add(x);
            count[x]++;
            if (count[x] > 2) {
                cant = true;
            }
        }

        if (cant) {
            out.println("NO");
        } else {
            out.println("YES");
            Collections.sort(list);
            List<Integer> increase = new ArrayList<>();
            List<Integer> decrease = new ArrayList<>();
            increase.add(list.get(0));
            for (int i = 1; i < n; i++) {
                if (list.get(i).equals(list.get(i - 1))) {
                    decrease.add(list.get(i));
                } else {
                    increase.add(list.get(i));
                }
            }
            Collections.reverse(decrease);
            out.println(increase.size());
            for (int x : increase) {
                out.print(x + " ");
            }
            out.println();
            out.println(decrease.size());
            for (int x : decrease) {

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

    private static class Triple<F, S, T> {

        private F first;

        private S second;

        private T third;

        public Triple() {}

        public Triple(F first, S second, T third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}
