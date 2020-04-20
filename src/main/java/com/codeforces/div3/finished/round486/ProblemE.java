package com.codeforces.div3.finished.round486;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        String s = scanner.next();
        String t = s;

        int ans = Integer.MAX_VALUE;

        int x;

        s = t;
        x = s.lastIndexOf('0');
        if (x != -1) {
            int k = s.length() - x - 1;
            s = removeElement(s, x);
            int y = s.lastIndexOf('0');
            if (y != -1) {
                k += (s.length() - y - 1);
                s = removeElement(s, y);
                if (s.isEmpty()) {
                    ans = Math.min(ans, k);
                } else {
                    int p = -1;
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) != '0') {
                            p = i;
                            break;
                        }
                    }
                    if (p != -1) {
                        k += p;
                        ans = Math.min(ans, k);
                    }
                }
            }
        }


        s = t;
        x = s.lastIndexOf('0');
        if (x != -1) {
            int k = s.length() - x - 1;
            s = removeElement(s, x);
            int y = s.lastIndexOf('5');
            if (y != -1) {
                k += (s.length() - y - 1);
                s = removeElement(s, y);
                if (s.isEmpty()) {
                    ans = Math.min(ans, k);
                } else {
                    int p = -1;
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) != '0') {
                            p = i;
                            break;
                        }
                    }
                    if (p != -1) {
                        k += p;
                        ans = Math.min(ans, k);
                    }
                }
            }
        }



        s = t;
        x = s.lastIndexOf('5');
        if (x != -1) {
            int k = s.length() - x - 1;
            s = removeElement(s, x);
            int y = s.lastIndexOf('2');
            if (y != -1) {
                k += (s.length() - y - 1);
                s = removeElement(s, y);
                if (s.isEmpty()) {
                    ans = Math.min(ans, k);
                } else {
                    int p = -1;
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) != '0') {
                            p = i;
                            break;
                        }
                    }
                    if (p != -1) {
                        k += p;
                        ans = Math.min(ans, k);
                    }
                }
            }
        }



        s = t;
        x = s.lastIndexOf('5');
        if (x != -1) {
            int k = s.length() - x - 1;
            s = removeElement(s, x);
            int y = s.lastIndexOf('7');
            if (y != -1) {
                k += (s.length() - y - 1);
                s = removeElement(s, y);
                if (s.isEmpty()) {
                    ans = Math.min(ans, k);
                } else {
                    int p = -1;
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) != '0') {
                            p = i;
                            break;
                        }
                    }
                    if (p != -1) {
                        k += p;
                        ans = Math.min(ans, k);
                    }
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {
            out.println(-1);
        } else {
            out.println(ans);
        }


        out.flush();
    }

    private static String removeElement(String str, int ind) {
        return str.substring(0, ind) + str.substring(ind + 1);
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
