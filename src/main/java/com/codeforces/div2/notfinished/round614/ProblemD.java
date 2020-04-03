package com.codeforces.div2.notfinished.round614;

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

        long x0 = scanner.nextLong();
        long y0 = scanner.nextLong();
        long ax = scanner.nextLong();
        long ay = scanner.nextLong();
        long bx = scanner.nextLong();
        long by = scanner.nextLong();

        long xs = scanner.nextLong();
        long ys = scanner.nextLong();
        long t = scanner.nextLong();

        List<Pair<Long, Long>> points = new ArrayList<>();
        long x = x0;
        long y = y0;
        while (true) {
            if (x > 100_000_000_000_000_000L) {
                break;
            }
            if (y > 100_000_000_000_000_000L) {
                break;
            }
            try {
                points.add(new Pair<>(x, y));
                long k = Math.multiplyExact(x, ax);
                x = Math.addExact(k, bx);
                k = Math.multiplyExact(y, ay);
                y = k + by;
            } catch (ArithmeticException ex) {
                break;
            }
        }

        int max = Integer.MIN_VALUE;

        long k = t;

        for (int nearest = 0; nearest < points.size(); nearest++) {
            t = k;
            Pair<Long, Long> nP = points.get(nearest);
            t = t - (Math.abs(nP.first - xs) + Math.abs(nP.second - ys));
            int ans = 0;
            if (t >= 0) {
                ans = 1;
                for (int i = nearest - 1; i >= 0; i--) {
                    Pair<Long, Long> p1 = points.get(i + 1);
                    Pair<Long, Long> p2 = points.get(i);
                    t = t - ((Math.abs(p1.first - p2.first) + Math.abs(p1.second - p2.second)));
                    if (t < 0) {
                        break;
                    }
                    ans++;
                }


                if (nearest != points.size() - 1) {
                    Pair<Long, Long> p1 = points.get(0);
                    Pair<Long, Long> p2 = points.get(nearest);
                    t = t - ((Math.abs(p1.first - p2.first) + Math.abs(p1.second - p2.second)));
                    for (int i = nearest + 1; i < points.size(); i++) {
                        p1 = points.get(i - 1);
                        p2 = points.get(i);
                        t = t - ((Math.abs(p1.first - p2.first) + Math.abs(p1.second - p2.second)));
                        if (t < 0) {
                            break;
                        } else {
                            ans++;
                        }
                    }
                }
            }
            max = Math.max(max, ans);
        }

        out.println(max);



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
