package com.codeforces.div2.notfinished.round637;

import java.io.*;
import java.util.*;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        List<String> numbers = Arrays.asList("1110111", "0010010", "1011101", "1011011",
                "0111010", "1101011", "1101111", "1010010", "1111111", "1111011");

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String[] list = new String[n];
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            list[i] = s;
        }

        List<Pair<Integer, Integer>> minMaxLis = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int min = 100;
            int max = -1;
            for (String t : numbers) {
                int x = changeAmount(list[i], t);
                if (x != -1) {
                    min = Math.min(min, x);
                    max = Math.max(max, x);
                }
            }
            minMaxLis.add(new Pair<>(min, max));
        }

        List<Pair<Integer, Integer>> dpMinMax = new ArrayList<>();
        dpMinMax.add(minMaxLis.get(n - 1));
        for (int i = n - 2; i >= 0; i--) {
            Pair<Integer, Integer> last = dpMinMax.get(dpMinMax.size() - 1);
            Pair<Integer, Integer> pair = minMaxLis.get(i);
            dpMinMax.add(new Pair<>(last.first + pair.first, last.second + pair.second));
        }
        Collections.reverse(dpMinMax);

        StringBuilder ans = new StringBuilder();
        boolean cant = false;
        for (int i = 0; i < n; i++) {
            if (k < dpMinMax.get(i).first || k > dpMinMax.get(i).second) {
                cant = true;
            }
            boolean find = false;
            for (int j = 9; j >= 0; j--) {
                String t = numbers.get(j);
                int x = changeAmount(list[i], t);
                if (x != -1) {
                    if (i == n - 1) {
                        if (x == k) {
                            ans.append((char) (j + '0'));
                            find = true;
                            break;
                        }
                    } else {
                        if (k - x >= dpMinMax.get(i + 1).first && k - x <= dpMinMax.get(i + 1).second) {
                            ans.append((char) (j + '0'));
                            find = true;
                            k = k - x;
                            break;
                        }
                    }
                }
            }
            if (!find) {
                cant = true;
                break;
            }
        }


        if (cant) {
            out.println(-1);
        } else {
            out.println(ans);
        }



        out.flush();
    }

    private static int changeAmount(String s, String t) {
        int x = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1' && t.charAt(i) == '0') {
                return -1;
            }
            if (s.charAt(i) == '0' && t.charAt(i) == '1') {
                x++;
            }
        }
        return x;
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
