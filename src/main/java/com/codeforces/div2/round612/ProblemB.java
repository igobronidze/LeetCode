package com.codeforces.div2.round612;

import java.io.*;
import java.util.*;

public class ProblemB {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            list.add(s);
            if (!map.containsKey(s)) {
                map.put(s, 0);
            }
            map.put(s, map.get(s) + 1);
        }

        long ans = 0;
        for (int i = 0 ; i < n; i++) {
            map.put(list.get(i), map.get(list.get(i)) - 1);
            for (int j = i + 1; j < n; j++) {
                map.put(list.get(j), map.get(list.get(j)) - 1);
                String s = getPossible(list.get(i), list.get(j));
                if (map.containsKey(s)) {
                    ans += map.get(s);
                }
            }

            for (int j = i + 1; j < n; j++) {
                map.put(list.get(j), map.get(list.get(j)) + 1);
            }
        }

        out.println(ans);

        out.flush();
    }

    private static String getPossible(String a, String b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                sb.append(a.charAt(i));
            } else {
                if ('S' != a.charAt(i) && 'S' != b.charAt(i)) {
                    sb.append('S');
                } else if ('E' != a.charAt(i) && 'E' != b.charAt(i)) {
                    sb.append('E');
                } else {
                    sb.append('T');
                }
            }
        }
        return sb.toString();
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
