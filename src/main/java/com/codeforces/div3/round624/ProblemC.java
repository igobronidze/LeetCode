package com.codeforces.div3.round624;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String s = scanner.next();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                list.add(scanner.nextInt());
            }
            list.add(n);
            Collections.sort(list);

            Map<Character, Integer> map = new TreeMap<>();
            for (char c = 'a'; c <= 'z'; c++) {
                map.put(c, 0);
            }

            int x = m + 1;
            int j = 0;
            for (int i = 0; i < n; i++) {
                while (list.get(j) == i && j <= m) {
                    j++;
                    x--;
                }
                map.put(s.charAt(i), map.get(s.charAt(i)) + x);
            }

            for (Integer k : map.values()) {
                out.print(k + " ");
            }
            out.println();
        }

        out.flush();
    }
}
