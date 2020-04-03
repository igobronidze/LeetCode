package com.codeforces.div2.notfinished.round621;

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

        String s = scanner.nextLine();

        long ans = 0;

        long dp[][] = new long[s.length() + 1]['z' + 1];

        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                dp[0][s.charAt(i)] = 1;
            } else {
                for (int j = 'a'; j <= 'z'; j++) {
                    dp[i][j] = dp[i - 1][j];
                }
                dp[i][s.charAt(i)] = dp[i - 1][s.charAt(i)] + 1;
            }
            ans = Math.max(ans, dp[i][s.charAt(i)]);
        }

        long[][] arr = new long['z' + 1]['z' + 1];

        for (int i = 1; i < s.length(); i++) {
            for (int j = 'a'; j <= 'z'; j++) {
                arr[j][s.charAt(i)] += dp[i - 1][j];
                ans = Math.max(arr[j][s.charAt(i)], ans);
            }
        }

        out.println(ans);

        out.flush();
    }
}
