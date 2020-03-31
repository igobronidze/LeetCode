package com.codeforces.div2.round625;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        String s = scanner.next();

        int ans = 0;

        for (char c = 'z'; c >= 'b'; c--) {
            int i = 0;
            while (i < s.length()) {
                if (s.charAt(i) == c) {
                    if (i != 0 && s.charAt(i - 1) == (char)(c - 1)) {
                        s = removeChar(s, i);
                        i = 0;
                        ans++;
                    } else if (i != s.length() - 1 && s.charAt(i + 1) == (char)(c - 1)) {
                        s = removeChar(s, i);
                        i = 0;
                        ans++;
                    } else {
                        i++;
                    }
                } else {
                    i++;
                }
            }
        }

        out.println(ans);


        out.flush();
    }

    private static String removeChar(String s, int index) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i != index) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
