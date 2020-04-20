package com.codeforces.div3.notfinished.round540;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int[] arr = new int[1001];

        for (int i = 0; i < n * n; i++) {
            arr[scanner.nextInt()]++;
        }

        int[][] ans = new int[n + 1][n + 1];

        boolean cant = false;
        int ind = 0;
        for (int i = 0; i < n /2; i++) {
            for (int j = 0; j < n / 2; j++) {
                while (arr[ind] < 4) {
                    ind++;
                    if (ind == 1001) {
                        break;
                    }
                }
                if (ind == 1001) {
                    cant = true;
                    break;
                } else {
                    ans[i][j] = ind;
                    ans[i][n - j - 1] = ind;
                    ans[n - i - 1][j] = ind;
                    ans[n - i - 1][n - j - 1] = ind;
                    arr[ind] -= 4;
                }
            }
            if (cant) {
                break;
            }
        }

        if (n % 2 == 1) {
            ind = 0;
            for (int i = 0; i < n / 2; i++) {
                while (arr[ind] < 2) {
                    ind++;
                    if (ind == 1001) {
                        break;
                    }
                }
                if (ind == 1001) {
                    cant = true;
                    break;
                } else {
                    ans[i][n / 2] = ind;
                    ans[n - i - 1][n / 2] = ind;
                    arr[ind] -= 2;
                }
            }

            if (!cant) {
                ind = 0;
                for (int i = 0; i < n / 2; i++) {
                    while (arr[ind] < 2) {
                        ind++;
                        if (ind == 1001) {
                            break;
                        }
                    }
                    if (ind == 1001) {
                        cant = true;
                        break;
                    } else {
                        ans[n / 2][i] = ind;
                        ans[n / 2][n - i - 1] = ind;
                        arr[ind] -= 2;
                    }
                }
            }

            if (!cant) {
                for (int i = 1; i <= 1000; i++) {
                    if (arr[i] == 1) {
                        ans[n / 2][n / 2] = i;
                        break;
                    }
                }
            }
        }

        if (cant) {
            out.println("NO");
        } else {
            out.println("YES");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    out.print(ans[i][j] + " ");
                }
                out.println();
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
