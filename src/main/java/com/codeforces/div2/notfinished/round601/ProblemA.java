package com.codeforces.div2.notfinished.round601;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemA {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 1);
        map.put(3, 2);
        map.put(4, 2);
        map.put(5, 1);
        map.put(6, 2);
        map.put(7, 2);
        map.put(8, 3);
        map.put(9, 3);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int x = Math.abs(a - b);
            int ans = x / 10 * 2;
            ans += map.get(x % 10);
            System.out.println(ans);
        }
        out.flush();
    }
}
