package com.codeforces.div2.notfinished.round600;

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

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < n; i++) {
            list.add(scanner.nextInt());
        }

        Collections.sort(list);
        Collections.reverse(list);

        long[] map = new long[m];
        for (int i = 0; i < n; i++) {
            int x = i % m;
            map[x] = map[x] + list.get(i);
        }

        long sum = 0;
        int d = 0;
        for (int i = 0; i < n; i++) {
            if (i % m == 0) {
                d++;
            }
            sum += (long)d * list.get(i);
        }

        List<Long> ans = new ArrayList<>();

        for (int i = 0 ; i < n; i++) {
            ans.add(sum);
            sum -= map[i % m];
            map[i % m] -= list.get(i);
        }

        Collections.reverse(ans);

        for (int i = 0; i < ans.size(); i++) {
            out.print(ans.get(i));
            if (i != ans.size() - 1) {
                out.print(" ");
            }
        }
        out.flush();
    }
}
