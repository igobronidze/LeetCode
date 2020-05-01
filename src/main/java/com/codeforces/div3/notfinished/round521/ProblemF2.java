package com.codeforces.div3.notfinished.round521;

import java.io.*;
import java.util.*;

public class ProblemF2 {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int x = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        if (k * (x + 1) - 1 >= n) {
            long[][] dp = new long[n][x + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= x; j++) {
                    dp[i][j] = Long.MIN_VALUE;
                }
            }

            PriorityQueue<Pair<Long, Integer>>[] queueMap = new PriorityQueue[x + 1];
            for (int i = 1; i <= x; i++) {
                queueMap[i] = new PriorityQueue<>((a, b) -> Long.compare(b.first, a.first));
            }
            dp[0][1] = list.get(0);
            queueMap[1].add(new Pair<>((long) list.get(0), 0));

            for (int i = 1; i < n ; i++) {
                for (int j = Math.min(x, i + 1); j >= 2; j--) {
                    long max = Long.MIN_VALUE;
                    PriorityQueue<Pair<Long, Integer>> queue = queueMap[j - 1];
                    while (!queue.isEmpty()) {
                        Pair<Long, Integer> pair = queue.peek();
                        if (i - k <= pair.second) {
                            max = pair.first;
                            break;
                        } else {
                            queue.poll();
                        }
                    }

                    if (max == Long.MIN_VALUE) {
                        dp[i][j] = max;
                    } else {
                        dp[i][j] = max + list.get(i);
                        queueMap[j].add(new Pair<>(dp[i][j], i));
                    }
                }
                if (i < k) {
                    dp[i][1] = list.get(i);
                    queueMap[1].add(new Pair<>(dp[i][1], i));
                }
            }

            long ans = Long.MIN_VALUE;
            for (int i = n - k; i < n; i++) {
                ans = Math.max(ans, dp[i][x]);
            }
            out.println(ans);

        } else {
            out.println(-1);
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
