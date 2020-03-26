package com.codeforces.div3.round624;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class ProblemE_New {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();

            if (d > n * (n - 1) / 2) {
                out.println("NO");
                continue;
            }

            d = n * (n - 1) / 2 - d;

            int[] ans = new int[n + 1];
            Map<Integer, LinkedList<Integer>> map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                map.put(i - 1, new LinkedList<>());
                map.get(i - 1).add(i);
                ans[i] = i -1;
            }
            int minPossibleDepth = 0;

            for (int i = n; i >= 0; i--) {
                int change = Math.min(d, (i - 2 - minPossibleDepth));
                int index = i - 2 - change;
                int x = map.get(index).poll();
                ans[i] = x;
                map.get(index + 1).add(i);
                map.get(index + 1).add(i);
                if (map.get(index).size() == 0) {
                    minPossibleDepth++;
                }
                d -= change;
                if (d == 0) {
                    break;
                }
            }

            if (d == 0) {
                out.println("YES");
                for (int i = 2; i <= n; i++) {
                    out.print(ans[i] + " ");
                }
                out.println();
            } else {
                out.println("NO");
            }

        }
        out.flush();
    }
}
