package com.codeforces.div3.finished.round590;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        char[] sArr = scanner.next().toCharArray();
        int q = scanner.nextInt();

        TreeSet<Integer>[] indexesArr = new TreeSet[200];
        for (int i = 'a'; i <= 'z'; i++) {
            indexesArr[i] = new TreeSet<>();
        }
        for (int i = 0; i < sArr.length; i++) {
            indexesArr[sArr[i]].add(i);
        }

        for (int i = 0; i < q; i++) {
            int t = scanner.nextInt();
            if (t == 1) {
                int pos = scanner.nextInt();
                pos--;
                char c = scanner.next().charAt(0);
                indexesArr[sArr[pos]].remove(pos);
                sArr[pos] = c;
                indexesArr[c].add(pos);
            } else {
                int ll = scanner.nextInt();
                int rr = scanner.nextInt();
                ll--;
                rr--;
                int ans = 0;
                for (int j = 'a'; j <= 'z'; j++) {
                    Integer next = indexesArr[j].higher(ll - 1);
                    if (next != null && next <= rr) {
                        ans++;
                    }
                }
                out.println(ans);
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
