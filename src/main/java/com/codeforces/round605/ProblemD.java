package com.codeforces.round605;

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
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            list.add(scanner.nextInt());
        }

        int[] deleted = new int[n];
        int[] notDeleted = new int[n];

        deleted[0] = 0;
        notDeleted[0] = 1;
        for (int i = 1; i < n; i++) {
            if (list.get(i) > list.get(i - 1)) {
                deleted[i] = deleted[i - 1] + 1;
                if (i != 1 && list.get(i) > list.get(i - 2)) {
                    deleted[i] = Math.max(deleted[i], notDeleted[i - 2] + 1);
                }
                notDeleted[i] = notDeleted[i - 1] + 1;
            } else {
                if (i == 1) {
                    deleted[i] = 1;
                } else if (list.get(i) > list.get(i - 2)) {
                    deleted[i] = notDeleted[i - 2] + 1;
                } else {
                    deleted[i] = 1;
                }
                notDeleted[i] = 1;
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n ; i++) {
            ans = Math.max(ans, deleted[i]);
            ans = Math.max(ans, notDeleted[i]);
        }

        out.println(ans);


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
