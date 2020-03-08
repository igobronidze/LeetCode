package com.codeforces.round617;

import java.io.*;
import java.util.*;

public class ProblemE_1 {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        String s = scanner.next();

        List<Pair<Character, Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair<>(s.charAt(i), i));
        }

        pairs.sort((o1, o2) -> {
            int x = Integer.compare(o1.first, o2.first);
            if (x != 0) {
                return x;
            }
            return Integer.compare(o1.second, o2.second);
        });


        int[] ans = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int x = pairs.get(i).second;
            boolean b1 = false;
            boolean b2 = false;
            for (int j = 0; j < x; j ++) {
                if (s.charAt(j) > s.charAt(x)) {
                    if (ans[j] == 1) {
                        b1 = true;
                    } else if (ans[j] == 2) {
                        b2 = true;
                    }
                }
            }

            if (ans[x] == 1 && b1) {
                out.println("NO");
                out.flush();
                return;
            }
            if (ans[x] == 2 && b2) {
                out.println("NO");
                out.flush();
                return;
            }
            if (b1 && b2) {
                out.println("NO");
                out.flush();
                return;
            }
            if (ans[x] == 0) {
                if (b1) {
                    ans[x] = 2;
                } else {
                    ans[x] = 1;
                }
            }
            for (int j = 0; j < x; j++) {
                if (s.charAt(j) > s.charAt(x)) {
                    ans[j] = ans[x] % 2 + 1;
                }
            }
        }

        out.println("YES");
        for (int i = 0; i < n; i++) {
            out.print(ans[i] - 1);
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
