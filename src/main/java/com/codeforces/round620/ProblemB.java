package com.codeforces.round620;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ProblemB {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            list.add(s);
        }

        String ans1 = "";
        String ans2 = "";
        String ans3 = "";

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (getRevers(list.get(i)).equals(list.get(j))) {
                    ans1 += list.get(i);
                    ans2 = list.get(j) + ans2;
                    list.remove(i);
                    list.remove(j - 1);
                    i--;
                    break;
                }
            }
        }

        for (String s : list) {
            if (isPalindrome(s)) {
                ans3 = s;
                break;
            }
        }

        String ans = ans1 + ans3 + ans2;
        out.println(ans.length());
        out.println(ans);

        out.flush();
    }

    private static String getRevers(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    private static boolean isPalindrome(String str) {
        return str.equals(getRevers(str));
    }
}
