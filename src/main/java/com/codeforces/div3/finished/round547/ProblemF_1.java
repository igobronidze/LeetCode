package com.codeforces.div3.finished.round547;

import java.io.*;
import java.util.*;

public class ProblemF_1 {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        List<Map<Integer, Integer>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dp.add(new HashMap<>());
            int x = 0;
            for (int j = i; j >= 0; j--) {
                x += list.get(j);
                if (j != 0) {
                    for (Map.Entry<Integer, Integer> entry : dp.get(j - 1).entrySet()) {
                        int a = entry.getValue();
                        if (x == entry.getKey()) {
                            a++;
                        }
                        if (!dp.get(i).containsKey(entry.getKey())) {
                            dp.get(i).put(entry.getKey(), a);
                        } else {
                            dp.get(i).put(entry.getKey(), Math.max(dp.get(i).get(entry.getKey()), a));
                        }
                    }
                }
                if (!dp.get(i).containsKey(x)) {
                    dp.get(i).put(x, 1);
                } else {
                    dp.get(i).put(x, Math.max(dp.get(i).get(x), 1));
                }
            }
        }

        int ans = 0, max = 0;
        for (Map.Entry<Integer, Integer> entry : dp.get(n - 1).entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                ans = entry.getKey();
            }
        }

        out.println(max);
        int ind = -1;
        for (int i = 0; i < n; i++) {
            int x = 0;
            for (int j = i; j > ind; j--) {
                x = x + list.get(j);
                if (x == ans) {
                    out.println((j + 1) + " " + (i + 1));
                    ind = i;
                    break;
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
