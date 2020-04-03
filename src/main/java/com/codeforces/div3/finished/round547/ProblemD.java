package com.codeforces.div3.finished.round547;

import java.io.*;
import java.util.*;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);


        int n = scanner.nextInt();
        String s = scanner.next();
        String t = scanner.next();

        Map<Character, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new LinkedList<>());
            }
            map.get(c).add(i + 1);
        }

        List<Pair<Integer, Integer>> ans = new ArrayList<>();
        List<Integer> q = new ArrayList<>();
        boolean[] used = new boolean[n + 1];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c == '?') {
                q.add(i + 1);
            } else {
                if (map.containsKey(c)) {
                    int x = map.get(c).poll();
                    ans.add(new Pair<>(x, i + 1));
                    if (map.get(c).isEmpty()) {
                        map.remove(c);
                    }
                    used[x] = true;
                } else {
                    if (map.containsKey('?')) {
                        int x = map.get('?').poll();
                        ans.add(new Pair<>(x, i + 1));
                        if (map.get('?').isEmpty()) {
                            map.remove('?');
                        }
                        used[x] = true;
                    }
                }
            }
        }

        int i = 1;
        for (int x : q) {
            while (used[i]) {
                i++;
            }
            ans.add(new Pair<>(i, x));
            i++;
        }

        out.println(ans.size());
        for (Pair<Integer, Integer> pair : ans) {
            out.println(pair.first + " " + pair.second);
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
