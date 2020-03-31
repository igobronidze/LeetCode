package com.codeforces.div2.round619;

import java.util.Scanner;

public class ProblemA {

    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        int n = Integer.parseInt(sin.nextLine());
        for (int k = 0; k < n; k++) {
            String a = sin.nextLine();
            String b = sin.nextLine();
            String c = sin.nextLine();
            boolean finished = false;
            for (int i = 0; i < a.length(); i++) {
                if (c.charAt(i) != a.charAt(i) && c.charAt(i) != b.charAt(i)) {
                    System.out.println("NO");
                    finished = true;
                    break;
                }
            }
            if (!finished) {
                System.out.println("YES");
            }
        }
    }
}
