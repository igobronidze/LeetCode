package com.codeforces.round486;

import java.io.*;
import java.util.*;

public class ProblemD {

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
        Collections.sort(list);

        Map<Integer, int[]> dp = new HashMap<>();
        int max = 0;
        int q = 0;
        int t = 0;
        for (int i = 0; i < n; i++) {
            dp.put(list.get(i), new int[31]);
            for (int j = 0; j <= 30; j++) {
                try {
                    int x = Math.subtractExact(list.get(i), (1 << j));
                    if (dp.containsKey(x)) {
                        dp.get(list.get(i))[j] = dp.get(x)[j] + 1;
                    } else {
                        dp.get(list.get(i))[j] = 1;
                    }
                    if (max < dp.get(list.get(i))[j] && max < 3) {
                        max = dp.get(list.get(i))[j];
                        q = list.get(i);
                        t = j;
                    }
                } catch (ArithmeticException ignored) {}
            }
        }


        out.println(max);
        for (int i = 0; i < max; i++) {
            out.print(q + " ");
            q = q - (1 << t);
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
