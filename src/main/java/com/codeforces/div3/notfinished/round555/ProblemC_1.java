package com.codeforces.div3.notfinished.round555;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ProblemC_1 {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(scanner.nextInt());
        }

        StringBuilder sb = new StringBuilder();
        int x = 0;
        if (linkedList.getFirst() > linkedList.getLast()) {
            sb.append('R');
            x = linkedList.removeLast();
        } else {
            sb.append('L');
            x = linkedList.removeFirst();
        }

        for (int i = 1; i < n; i++) {
            if (linkedList.getFirst() < x && linkedList.getLast() < x) {
                break;
            } else {
                if (linkedList.getFirst() > x && linkedList.getLast() < x) {
                    sb.append('L');
                    x = linkedList.removeFirst();
                } else if (linkedList.getLast() > x && linkedList.getFirst() < x) {
                    sb.append('R');
                    x = linkedList.removeLast();
                } else
                if (linkedList.getFirst() < linkedList.getLast()) {
                    sb.append('L');
                    x = linkedList.removeFirst();
                } else {
                    sb.append('R');
                    x = linkedList.removeLast();
                }
            }
        }

        out.println(sb.length());
        out.println(sb.toString());


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

        public Pair() {
        }

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
