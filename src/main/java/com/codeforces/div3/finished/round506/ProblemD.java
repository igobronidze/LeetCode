package com.codeforces.div3.finished.round506;

import java.io.*;
import java.util.*;

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

        Map<Integer, Integer>[] rem = new HashMap[11];
        for (int i = 0; i <= 10; i++) {
            rem[i] = new HashMap<>();
        }

        for (int i = 0; i < n; i++) {
            int length = getDigitsCount(list.get(i));
            int mod = list.get(i) % k;
            if (!rem[length].containsKey(mod)) {
                rem[length].put(mod, 0);
            }
            rem[length].put(mod, rem[length].get(mod) + 1);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= 10; j++) {
                long x = ((long) list.get(i) % k) * ((long) Math.pow(10, j) % k);
                int mod = (k - (int)(x % k)) % k;
                ans += rem[j].getOrDefault(mod, 0);
            }
        }

        for (int i = 0; i < n; i++) {
            long x = ((long) Math.pow(10, getDigitsCount(list.get(i))) % k) * list.get(i) + list.get(i);
            if (x % k == 0) {
                ans--;
            }
        }

        out.println(ans);


        out.flush();
    }

    private static int getDigitsCount(int x) {
        return Integer.toString(x).length();
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
