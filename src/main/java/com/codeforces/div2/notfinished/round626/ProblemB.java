package com.codeforces.div2.notfinished.round626;

import java.io.*;
import java.util.*;

public class ProblemB {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int a[] = new int[n + 1];
        int b[] = new int[m + 1];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        Map<Integer, Integer> aMap = new HashMap<>();
        Map<Integer, Integer> bMap = new HashMap<>();
        int x = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                if (x > 0) {
                    if (!aMap.containsKey(x)) {
                        aMap.put(x, 0);
                    }
                    aMap.put(x, aMap.get(x) + 1);
                }
                x = 0;
            } else {
                x++;
            }
        }
        if (x > 0) {
            if (!aMap.containsKey(x)) {
                aMap.put(x, 0);
            }
            aMap.put(x, aMap.get(x) + 1);
        }

        x = 0;
        for (int i = 0; i < m; i++) {
            if (b[i] == 0) {
                if (x > 0) {
                    if (!bMap.containsKey(x)) {
                        bMap.put(x, 0);
                    }
                    bMap.put(x, bMap.get(x) + 1);
                }
                x = 0;
            } else {
                x++;
            }
        }
        if (x > 0) {
            if (!bMap.containsKey(x)) {
                bMap.put(x, 0);
            }
            bMap.put(x, bMap.get(x) + 1);
        }

        List<Integer> divK = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(k); i++) {
            if (k % i == 0) {
                divK.add(i);
                if (i != k / i) {
                    divK.add(k / i);
                }
            }
        }

        long ans = 0;
        for (Map.Entry<Integer, Integer> aEntry : aMap.entrySet()) {
            for (Map.Entry<Integer, Integer> bEntry : bMap.entrySet()) {
                for (int d : divK) {
                    if (aEntry.getKey() >= d && bEntry.getKey() >= k / d) {
                        ans = ans + (long) aEntry.getValue() * bEntry.getValue() *
                                (aEntry.getKey() - d + 1) * (bEntry.getKey() - k / d + 1);
                    }
                }
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
}
