package com.codeforces.div3.finished.round570;

import java.io.*;
import java.util.*;

public class ProblemG {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if (!map.containsKey(x)) {
                    map.put(x, new Pair<>(0, 0));
                }
                Pair<Integer, Integer> pair = map.get(x);
                pair.first++;
                pair.second += y;
                map.put(x, pair);
            }

            List<Pair<Integer, Integer>> countOfTypes = new ArrayList<>(map.values());
            countOfTypes.sort(Comparator.comparingInt(pair -> pair.first));
            Collections.reverse(countOfTypes);

            int count = 0;
            int good = 0;
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            int i = 0;
            int x = countOfTypes.get(i).first;
            while (i < countOfTypes.size()) {
                if (countOfTypes.get(i).first < x && priorityQueue.isEmpty()) {
                    x = countOfTypes.get(i).first;
                }
                while (i < countOfTypes.size() && x == countOfTypes.get(i).first) {
                    priorityQueue.add(countOfTypes.get(i).second);
                    i++;
                }
                count += x;
                good += Math.min(priorityQueue.poll(), x);
                x--;
            }
            while (x > 0 && !priorityQueue.isEmpty()) {
                count += x;
                good += Math.min(priorityQueue.poll(), x);
                x--;
            }

            out.println(count + " " + good);

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
