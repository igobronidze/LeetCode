package com.codeforces.div3.finished.round481;

import java.io.*;
import java.util.*;

public class ProblemG {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Map<Integer, List<Pair<Integer, Pair<Integer, Integer>>>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int s = scanner.nextInt();
            int d = scanner.nextInt();
            int c = scanner.nextInt();
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(new Pair<>(d, new Pair<>(c, i + 1)));
            set.add(d);
        }

        PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.first));
        boolean cant = false;
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (map.containsKey(i)) {
                for (Pair<Integer, Pair<Integer, Integer>> pair : map.get(i)) {
                    for (int j = 0; j < pair.second.first; j++) {
                        priorityQueue.add(new Pair<>(pair.first, pair.second.second));
                    }
                }
            }
            if (!set.contains(i)) {
                if (!priorityQueue.isEmpty()) {
                    Pair<Integer, Integer> pair = priorityQueue.poll();
                    if (pair.first <= i) {
                        cant = true;
                        break;
                    } else {
                        ans.add(pair.second);
                    }
                } else {
                    ans.add(0);
                }
            } else {
                ans.add(m + 1);
            }
        }
        if (cant || !priorityQueue.isEmpty()) {
            out.println(-1);
        } else {
            for (int x : ans) {
                out.print(x + " ");
            }
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
