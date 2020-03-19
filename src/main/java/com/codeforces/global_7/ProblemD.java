package com.codeforces.global_7;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

//        int t = scanner.nextInt();
//        for (int p = 0; p < t; p++) {
//            String s = scanner.next();
//            int x = -1;
//            for (int i = 0; i < s.length() / 2; i++) {
//                if (s.charAt(i) == s.charAt(s.length() - 1 - i)) {
//                    x = i;
//                } else {
//                    break;
//                }
//            }
//            String mid = s.substring(x + 1, s.length() - x - 1);
//
//            String maxMidPal = "";
//            for (int i = 1; i <= mid.length(); i++) {
//                String str = mid.substring(0, i);
//                if (isPalindrome(str)) {
//                    if (maxMidPal.length() < str.length()) {
//                        maxMidPal = str;
//                    }
//                }
//            }
//
//            for (int i = 0; i < mid.length(); i++) {
//                String str = mid.substring(i);
//                if (isPalindrome(str)) {
//                    if (maxMidPal.length() < str.length()) {
//                        maxMidPal = str;
//                    }
//                }
//            }
//
//            out.println(s.substring(0, x + 1) + maxMidPal + s.substring(s.length() - 1 - x));
//
//        }

        out.println(longestPalindromicPrefix("basldnsfvd"));

        out.flush();
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static int longestPalindromicPrefix(String s) {
        String res = s;
        int len;

        s = getReverseString(s);
        s = res + "#" + s;

        int[] arr = new int[s.length() + 1];
        int i=0, j=1;

        len = s.length();
        while(j < len){
            if(s.charAt(i) == s.charAt(j)){
                arr[j] = i+1;
                i++; j++;
            } else {
                if(i>=1){
                    i = arr[i-1];
                }else{
                    arr[j] = 0;
                    j++;
                }
            }
        }

        return res.length() - arr[len-1];
    }

    private static String getReverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
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
