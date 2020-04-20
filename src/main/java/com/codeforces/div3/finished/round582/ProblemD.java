package com.codeforces.div3.finished.round582;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
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

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        Collections.sort(list);

        Pair<Integer, Integer>[] arr = new Pair[200005];
        for (int i = 0; i <= 200000; i++) {
            arr[i] = new Pair<>(0, 0);
        }
        for (int i = 0; i < n; i++) {
            int x = list.get(i);
            int a = 0;
            while (x != 0) {
                if (arr[x].first == k) {
                    break;
                }
                arr[x].first++;
                arr[x].second += a;
                a++;
                x = x / 2;
            }
            if (arr[x].first != k) {
                arr[x].first++;
                arr[x].second += a;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= 200000; i++) {
            if (arr[i].first >= k) {
                ans = Math.min(ans, arr[i].second);
            }
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
