package com.codeforces.div3.finished.round582;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        String s = scanner.next();
        String t = scanner.next();

        String str = "abc";

        List<String> perms = getAllPerm(str);
        String ans = null;
        for (String p : perms) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(p);
            }
            if (canSolve(sb.toString(), s, t)) {
                ans = sb.toString();
                break;
            }
        }

        StringBuilder allA = new StringBuilder();
        for (int i = 0; i < n; i++) {
            allA.append("a");
        }
        StringBuilder allB = new StringBuilder();
        for (int i = 0; i < n; i++) {
            allB.append("b");
        }
        StringBuilder allC = new StringBuilder();
        for (int i = 0; i < n; i++) {
            allC.append("c");
        }

        String ppp = allA.toString() + allB.toString() + allC.toString();
        if (canSolve(ppp, s, t)) {
            ans = ppp;
        }
        ppp = allA.toString() + allC.toString() + allB.toString();
        if (canSolve(ppp, s, t)) {
            ans = ppp;
        }
        ppp = allB.toString() + allA.toString() + allC.toString();
        if (canSolve(ppp, s, t)) {
            ans = ppp;
        }
        ppp = allB.toString() + allC.toString() + allA.toString();
        if (canSolve(ppp, s, t)) {
            ans = ppp;
        }
        ppp = allC.toString() + allA.toString() + allB.toString();
        if (canSolve(ppp, s, t)) {
            ans = ppp;
        }
        ppp = allC.toString() + allB.toString() + allA.toString();
        if (canSolve(ppp, s, t)) {
            ans = ppp;
        }



        if (ans == null) {
            out.println("NO");
        } else {
            out.println("YES");
            out.println(ans);
        }



        out.flush();
    }

    private static boolean canSolve(String str, String s, String t) {
        return !isSubs(str, s) && !isSubs(str, t);
    }

    private static boolean isSubs(String str, String ex) {
        for (int i = 0; i <= str.length() - ex.length(); i++) {
            if (ex.equals(str.substring(i, i + ex.length()))) {
                return true;
            }
        }
        return false;
    }

    private static List<String> getAllPerm(String str) {
        List<String> result = new ArrayList<>();
        if (str.length() == 1) {
            result.add(str);
            return result;
        }
        for (int i = 0; i < str.length(); i++) {
            List<String> perms = getAllPerm(str.substring(0, i) + str.substring(i + 1));
            for (String p : perms) {
                result.add(str.charAt(i) + p);
            }
        }
        return result;
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
