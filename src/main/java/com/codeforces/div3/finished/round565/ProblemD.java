package com.codeforces.div3.finished.round565;

import java.io.*;
import java.util.*;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int m = 2750131;

        List<Integer> primes = getAllPrime(m);
        Map<Integer, Integer> primesMap = new HashMap<>();
        for (int i = 0; i< primes.size(); i++) {
            primesMap.put(primes.get(i), i + 1);
        }

        int n = scanner.nextInt();
        List<Integer> input = new ArrayList<>();
        int[] cc = new int[m + 1];
        for (int i = 0; i < 2 * n; i++) {
            int x = scanner.nextInt();
            input.add(x);
            cc[x]++;
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = m; i >= 2; i--) {
            while (cc[i] > 0) {
                if (primesMap.containsKey(i)) {
                    cc[primesMap.get(i)]--;
                    ans.add(primesMap.get(i));
                } else {
                    for (int j = 2; j <= Math.sqrt(i); j++) {
                        if (i % j == 0) {
                            int x = i / j;
                            cc[x]--;
                            ans.add(i);
                            break;
                        }
                    }
                }
                cc[i]--;
            }
        }

        for (int x : ans) {
            out.print(x + " ");
        }



        out.flush();
    }

    private static List<Integer> getAllPrime(int before) {
        List<Integer> primes = new ArrayList<>();

        boolean[] sieve = new boolean[before + 1];
        for (int i = 2; i <= before; i++) {
            if (!sieve[i]) {
                primes.add(i);
                for (long j = (long)i * i; j <= before; j+= i) {
                    sieve[(int)j] = true;
                }
            }
        }

        return primes;
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
