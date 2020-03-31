package com.codeforces.div3.notfinished.round527;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemD1 {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        int x = 0;
        int y = 0;

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (list.get(i) % 2 == 0) {
                if (y != 0) {
                    if (y % 2 == 1) {
                        linkedList.add(y);
                    } else {
                        if (!linkedList.isEmpty()) {
                            x = linkedList.removeLast();
                        }
                    }
                }
                x++;
                y = 0;
            } else {
                if (x != 0) {
                    if (x % 2 == 1) {
                        linkedList.add(x);
                    } else {
                        if (!linkedList.isEmpty()) {
                            y = linkedList.removeLast();
                        }
                    }
                }
                y++;
                x = 0;
            }
        }
        if (x != 0) {
            if (x % 2 == 1) {
                linkedList.add(x);
            }
        } else if (y != 0) {
            if (y % 2 == 1) {
                linkedList.add(y);
            }
        }

        if (linkedList.size() <= 1) {
            out.println("YES");
        } else {
            out.println("NO");
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
