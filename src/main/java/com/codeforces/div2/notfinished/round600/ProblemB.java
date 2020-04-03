package com.codeforces.div2.notfinished.round600;

import java.util.*;

public class ProblemB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < n; i++) {
            list.add(scanner.nextInt());
        }

        boolean cant = false;
        Set<Integer> currEmployees = new HashSet<>();
        Set<Integer> dayEmployees = new HashSet<>();

        int k = 0;

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i != 0 && currEmployees.isEmpty()) {
                ans.add(i - k);
                k = i;
                dayEmployees.clear();
            }
            int x = list.get(i);
            if (x > 0) {
                if (currEmployees.contains(x)) {
                    System.out.println(-1);
                    cant = true;
                    break;
                } else {
                    if (dayEmployees.contains(x)) {
                        System.out.println(-1);
                        cant = true;
                        break;
                    } else {
                        currEmployees.add(x);
                        dayEmployees.add(x);
                    }
                }
            } else {
                x = x * -1;
                if (!currEmployees.contains(x)) {
                    System.out.println(-1);
                    cant = true;
                    break;
                } else {
                    currEmployees.remove(x);
                }
            }
        }

        if (!dayEmployees.isEmpty()) {
            ans.add(n - k);
        }

        if (!cant && !currEmployees.isEmpty()) {
            System.out.println(-1);
            cant = true;
        }

        if (!cant) {
            System.out.println(ans.size());
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i));
                if (i != ans.size() -1) {
                    System.out.print(" ");
                }
            }
        }
    }
}
