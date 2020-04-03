package com.codeforces.div3.notfinished.round582;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        String s = scanner.next();
        String t = scanner.next();

        String str = "abc";

        List<String> perms = getAllPerm(str);
        for (String p : perms) {
            boolean cant = false;
            for (int i = 0; i < p.length() - 1; i++) {
                String k = p.substring(i, i + s.length());
                if (k.equals(s) || k.equals(t)) {
                    cant = true;
                    break;
                }
            }
            if (!cant) {
                if (n == 1) {
                    out.println("YES");
                    for (int i = 0; i < n; i++) {
                        out.print(p);
                    }
                    out.flush();
                    return;
                } else {
                    String k = "" + p.charAt(p.length() - 1) + p.charAt(0);
                    if (!k.equals(s) && !k.equals(t)) {
                        out.println("YES");
                        for (int i = 0; i < n; i++) {
                            out.print(p);
                        }
                        out.flush();
                        return;
                    }
                }
            }
        }

        out.println("NO");



        out.flush();
    }

    private static List<String> getAllPerm(String str) {
        List<String> result = new ArrayList<>();
        if (str.length() == 1) {
            result.add(str);
            return result;
        }
        for (int i = 0; i < str.length(); i++) {
            List<String> perms = getAllPerm(str.substring(0, i) + str.substring(i + 1));
            for (String p : perms) {
                result.add(str.charAt(i) + p);
            }
        }
        return result;
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
