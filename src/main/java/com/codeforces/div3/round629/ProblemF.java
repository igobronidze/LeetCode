package com.codeforces.div3.round629;

import java.io.*;
import java.util.*;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLong());
        }

        Collections.sort(list);
        List<Pair<Long, Long>> pairs = new ArrayList<>();
        long count = 1;
        for (int i = 1; i < n; i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                count++;
            } else {
                pairs.add(new Pair<>(list.get(i - 1), count));
                count = 1;
            }
        }
        pairs.add(new Pair<>(list.get(n - 1), count));

        long[] dpLeft = new long[pairs.size()];
        count = pairs.get(0).second;
        for (int i = 1; i < pairs.size(); i++) {
            dpLeft[i] = dpLeft[i - 1] + count * (pairs.get(i).first - pairs.get(i - 1).first);
            count += pairs.get(i).second;
        }

        long[] dpRight = new long[pairs.size()];
        count = pairs.get(pairs.size() - 1).second;
        for (int i = pairs.size() - 2; i >= 0; i--) {
            dpRight[i] = dpRight[i + 1] + count * (pairs.get(i + 1).first - pairs.get(i).first);
            count += pairs.get(i).second;
        }

        long ans = Long.MAX_VALUE;
        count = 0;
        for (int i = 0; i < pairs.size(); i++) {
            long x = Long.MAX_VALUE;
            if (pairs.get(i).second >= k) {
                x = 0;
            } else {
                if (n - count >= k) {
                    x = (pairs.get(i + 1).first - pairs.get(i).first) * (k - pairs.get(i).second) + dpRight[i + 1];
                }
                if (count + pairs.get(i).second >= k) {
                    x = Math.min(x, (pairs.get(i).first - pairs.get(i - 1).first) * (k - pairs.get(i).second) + dpLeft[i - 1]);
                }
                if (i != 0 && i != pairs.size() - 1) {
                    long p = dpLeft[i - 1] + dpRight[i + 1];
                    p += count * (pairs.get(i).first - pairs.get(i - 1).first);
                    p += (n - count - pairs.get(i).second) * (pairs.get(i + 1).first - pairs.get(i).first);
                    p = p - (n - k);
                    x = Math.min(x, p);
                }
            }
            count += pairs.get(i).second;
            ans = Math.min(ans, x);
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

        public Pair() {
        }

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
