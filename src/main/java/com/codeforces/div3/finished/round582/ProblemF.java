package com.codeforces.div3.finished.round582;

import java.io.*;
import java.util.*;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> s = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            s.add(--x);
        }
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            t.add(--x);
        }
        char[] ans = new char[n + 1];

        Set<Integer> setS = new HashSet<>();
        Set<Integer> setT = new HashSet<>();
        int x = 0;
        int i = 0, j = 0;
        while (i < n) {
            ans[s.get(i)] = getChar(x);
            setS.add(s.get(i));
            i++;
            while (!setS.isEmpty() || !setT.isEmpty()) {
                if (!setS.isEmpty()) {
                    int ind = t.get(j);
                    if (setS.contains(ind)) {
                        setS.remove(ind);
                    } else {
                        setT.add(ind);
                        ans[ind] = getChar(x);
                    }
                    j++;
                } else if (!setT.isEmpty()) {
                    int ind = s.get(i);
                    if (setT.contains(ind)) {
                        setT.remove(ind);
                    } else {
                        setS.add(ind);
                        ans[ind] = getChar(x);
                    }
                    i++;
                }
            }
            x++;
        }


        if (x < k) {
            out.println("NO");
        } else {
            out.println("YES");
            for (int q = 0; q < n; q++) {
                out.print(ans[q]);
            }
        }



        out.flush();
    }

    private static char getChar(int x) {
        int c = 'a' + x;
        if (c <= 'z') {
            return (char)c;
        } else {
            return 'z';
        }
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
