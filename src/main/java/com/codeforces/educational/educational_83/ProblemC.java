package com.codeforces.educational.educational_83;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            List<Long> list = new ArrayList<>();
            for (int i = 0; i < n ; i++) {
                list.add(scanner.nextLong());
            }

            boolean b = false;
            while (true) {
                int x = 0, y = 0;
                for (int i = 0; i < n; i++) {
                    if (list.get(i) != 0) {
                        x++;
                        if (list.get(i) % k == 1) {
                            y++;
                        } else if (list.get(i) % k != 0) {
                            b = true;
                            break;
                        }
                    }
                }
                if (x == 0) {
                    break;
                }
                if (b) {
                    break;
                }
                if (y > 1) {
                    b = true;
                    break;
                }
                for (int i = 0; i < n; i++) {
                    if (list.get(i) % k == 0){
                        list.set(i, list.get(i) / k);
                    } else {
                        list.set(i, list.get(i) - 1);
                        list.set(i, list.get(i) / k);
                    }
                }
            }
            if (b) {
                out.println("NO");
            } else {
                out.println("YES");
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
}
