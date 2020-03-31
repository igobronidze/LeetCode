package com.codeforces.div3.finished.round506;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        long a = scanner.nextLong();
        long b = scanner.nextLong();

        long ans = (a + b + 1) * 2;

        List<Integer> aDivisibles = new ArrayList<>();
        List<Integer> bDivisibles = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                aDivisibles.add(i);
            }
        }
        for (int i = 1; i <= Math.sqrt(b); i++) {
            if (b % i == 0) {
                bDivisibles.add(i);
            }
        }


        int indexA = 0;
        int indexB = 0;
        for (int i = 1; i <= Math.sqrt(a + b); i++) {
            if ((a + b) % i == 0) {
                while (true) {
                    if (indexA == aDivisibles.size() - 1 || aDivisibles.get(indexA + 1) > i) {
                        break;
                    } else {
                        indexA++;
                    }
                }
                if ((a + b) / i >= a / aDivisibles.get(indexA)) {
                    ans = Math.min(ans, 2L * ((a + b) / i + i));
                }

                while (true) {
                    if (indexB == bDivisibles.size() - 1 || bDivisibles.get(indexB + 1) > i) {
                        break;
                    } else {
                        indexB++;
                    }
                }
                if ((a + b) / i >= b / bDivisibles.get(indexB)) {
                    ans = Math.min(ans, 2L * ((a + b) / i + i));
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
