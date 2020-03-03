package com.codeforces.ozon_tech_challenge_2020;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProblemB {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        String s = scanner.next();

        List<Integer> ans = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                a.add(i + 1);
            } else {
                b.add(i + 1);
            }
        }

        int i = 0;
        int j = b.size() - 1;
        while (i < a.size() && j >= 0) {
            if (a.get(i) > b.get(j)) {
                break;
            }
            ans.add(a.get(i));
            ans.add(b.get(j));
            i++;
            j--;
        }

        Collections.sort(ans);

        if (ans.isEmpty()) {
            out.println(0);
        } else {
            out.println(1);
            out.println(ans.size());
            for (int x : ans) {
                out.print(x + " ");
            }
        }


        out.flush();
    }
}
