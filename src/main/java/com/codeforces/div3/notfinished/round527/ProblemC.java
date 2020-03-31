package com.codeforces.div3.notfinished.round527;

import java.io.*;
import java.util.*;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        List<String> list = new ArrayList<>();
        String str1 = null, str2 = null;
        for (int i = 0; i < 2 * n - 2; i++) {
            String s = scanner.next();
            if (s.length() == n - 1) {
                if (str1 == null) {
                    str1 = s;
                } else {
                    str2 = s;
                }
            }
            list.add(s);
        }

        Set<Integer> prefixes = new HashSet<>();
        Set<Integer> suffixes = new HashSet<>();

        StringBuilder stringBuilder = new StringBuilder();
        String str = str1 + str2.charAt(str2.length() - 1);
        boolean cant = false;
        for (int i = 0; i < 2 * n - 2; i++) {
            if (prefixes.contains(list.get(i).length())) {
                if (isSuffix(str, list.get(i))) {
                    stringBuilder.append("S");
                } else {
                    cant = true;
                    break;
                }
            } else if (suffixes.contains(list.get(i).length())) {
                if (isPrefix(str, list.get(i))) {
                    stringBuilder.append("P");
                } else {
                    cant = true;
                    break;
                }
            } else {
                if (isPrefix(str, list.get(i))) {
                    stringBuilder.append("P");
                    prefixes.add(list.get(i).length());
                } else {
                    stringBuilder.append("S");
                    suffixes.add(list.get(i).length());
                }
            }
        }

        if (cant) {
            str = str2 + str1.charAt(str1.length() - 1);
            prefixes.clear();
            suffixes.clear();
            stringBuilder = new StringBuilder();

            for (int i = 0; i < 2 * n - 2; i++) {
                if (prefixes.contains(list.get(i).length())) {
                    if (isSuffix(str, list.get(i))) {
                        stringBuilder.append("S");
                    }
                } else if (suffixes.contains(list.get(i).length())) {
                    if (isPrefix(str, list.get(i))) {
                        stringBuilder.append("P");
                    }
                } else {
                    if (isPrefix(str, list.get(i))) {
                        stringBuilder.append("P");
                        prefixes.add(list.get(i).length());
                    } else {
                        stringBuilder.append("S");
                        suffixes.add(list.get(i).length());
                    }
                }
            }

            out.println(stringBuilder.toString());
        } else {
            out.println(stringBuilder.toString());
        }



        out.flush();
    }

    private static boolean isPrefix(String str, String prefix) {
        for (int i = 0; i < prefix.length(); i++) {
            if (str.charAt(i) != prefix.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSuffix(String str, String suffix) {
        for (int i = suffix.length() - 1; i >= 0; i--) {
            if (str.charAt(i + (str.length() - suffix.length())) != suffix.charAt(i)) {
                return false;
            }
        }
        return true;
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
