package com.codeforces.div2.notfinished.round600;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a.add(scanner.nextInt());
            }
            for (int i = 0; i < n; i++) {
                b.add(scanner.nextInt());
            }

            boolean hasDiff = false;
            int diff = 0;
            boolean no = false;
            for (int i = 0; i < n; i++) {
                if (!a.get(i).equals(b.get(i))) {
                    if (a.get(i) > b.get(i)) {
                        System.out.println("NO");
                        no = true;
                        break;
                    }
                    if (hasDiff) {
                        if (b.get(i) - a.get(i) != diff) {
                            System.out.println("NO");
                            no = true;
                            break;
                        }
                    } else {
                        hasDiff = true;
                        diff = b.get(i) - a.get(i);
                    }
                } else {
                    diff = 0;
                }
            }
            if (!no) {
                System.out.println("YES");
            }
        }
    }
}
