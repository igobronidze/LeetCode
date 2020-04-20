package com.codeforces.div3.finished.round598;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int q = scanner.nextInt();
        for (int p = 0; p < q; p++) {
            int n = scanner.nextInt();
            String s = scanner.next();
            String t = scanner.next();

            Map<Character, Integer> sMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (!sMap.containsKey(s.charAt(i))) {
                    sMap.put(s.charAt(i), 0);
                }
                sMap.put(s.charAt(i), sMap.get(s.charAt(i)) + 1);
            }
            Map<Character, Integer> tMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (!tMap.containsKey(t.charAt(i))) {
                    tMap.put(t.charAt(i), 0);
                }
                tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
            }

            boolean cant = false;
            for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
                if (!tMap.containsKey(entry.getKey()) || !tMap.get(entry.getKey()).equals(entry.getValue())) {
                    cant = true;
                }
            }

            if (cant) {
                out.println("NO");
            } else {
                boolean can = false;
                for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
                    if (entry.getValue() > 1) {
                        can = true;
                    }
                }
                if (can) {
                    out.println("YES");
                } else {
                    int x = 0, y = 0;
                    for (int i = 0; i < n; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (s.charAt(i) > s.charAt(j)) {
                                x++;
                            }
                            if (t.charAt(i) > t.charAt(j)) {
                                y++;
                            }
                        }
                    }
                    if (x % 2 == y % 2) {
                        out.println("YES");
                    } else {
                        out.println("NO");
                    }
                }
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
