package com.codeforces.round615;

import java.io.*;
import java.util.*;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int q = scanner.nextInt();
        int x = scanner.nextInt();


        PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            int x1 = Integer.compare(o1.first, o2.first);
            if (x1 == 0) {
                return Integer.compare(o1.second, o2.second);
            }
            return x1;
        });
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < x; i++) {
            priorityQueue.add(new Pair<>(0, i));
            map.put(i, 0);
        }

        for (int i = 0; i < q; i++) {
            int y = scanner.nextInt();
            y = y % x;

            map.put(y, map.get(y) + 1);
            priorityQueue.add(new Pair<>(map.get(y), y));
            Pair<Integer, Integer> pair;
            while (true) {
                pair = priorityQueue.peek();
                if (!map.get(pair.second).equals(pair.first)) {
                    priorityQueue.poll();
                } else {
                    break;
                }
            }
            out.println(pair.first * x + pair.second);
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

        public Pair() {
        }

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
