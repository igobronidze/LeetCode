package com.codeforces.div2.notfinished.round626;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        String s = scanner.next();

        int ans = 0;
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                x++;
            } else {
                y++;
            }
        }
        if (x != y) {
            out.println(-1);
        } else {
            int k = 0;
            int a = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '(') {
                    k++;
                } else {
                    k--;
                }
                if (k == 0) {
                    if (a > 0) {
                        a++;
                        ans += a;
                    }
                    a = 0;
                } else if (k < 0) {
                    a++;
                }
            }
            out.println(ans);
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
}
