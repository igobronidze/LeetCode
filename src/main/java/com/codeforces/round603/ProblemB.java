package com.codeforces.round603;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemB {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            List<String> list = new ArrayList<>();
            for (int i = 0 ; i < n; i++) {
                list.add(scanner.next());
            }
            List<String> ans = new ArrayList<>();
            int c = 0;
            for (int i = 0; i < n; i++) {
                if (ans.contains(list.get(i))) {
                    c++;
                    for (char k = '0'; k <= '9'; k++) {
                        String str = list.get(i).substring(0, 3) + k;
                        if (!ans.contains(str) && !list.contains(str)) {
                            ans.add(str);
                            break;
                        }
                    }
                } else {
                    ans.add(list.get(i));
                }
            }

            out.println(c);
            for (String s : ans) {
                out.println(s);
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
}
