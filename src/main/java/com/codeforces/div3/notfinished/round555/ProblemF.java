package com.codeforces.div3.notfinished.round555;

import java.io.*;
import java.util.*;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int[] cArr = new int[200002];

        for (int i = 0; i < n; i++) {
            cArr[scanner.nextInt()]++;
        }

        int ans = 0;
        int c = 0;
        int x = 0;
        for (int i = 1; i <= 200001; i++) {
            if (cArr[i] == 0) {
                if (c > 0) {
                    if (c > ans) {
                        ans = c;
                        x = i - 1;
                    }
                }
                c = 0;
            } else {
                if (cArr[i] == 1) {
                    c++;
                    if (c != 1) {
                        if (c > ans) {
                            ans = c;
                            x = i;
                        }
                        c = 1;
                    }
                } else {
                    c += cArr[i];
                }
            }
        }

        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < cArr[x]; i++) {
            ansList.add(x);
        }
        int p = x;
        for (int i = x - 1; i > 0; i--) {
            if (cArr[i] == 0) {
                break;
            } else if (cArr[i] == 1) {
                p = i;
                break;
            }
            for (int j = 0; j < cArr[i] - 1; j++) {
                ansList.add(i);
            }
            p = i;
        }
        for (int i = p; i < x; i++) {
            ansList.add(i);
        }

//        if (ans == 73893) {
//            out.println(ansList.get(66510) + " " + ansList.get(66511) + " " + ansList.get(66512));
//        }
        out.println(ans);
        for (int i = 0; i < ansList.size(); i++) {
            out.print(ansList.get(i) + " ");
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
