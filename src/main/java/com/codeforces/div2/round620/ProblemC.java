package com.codeforces.div2.round620;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int f = scanner.nextInt();
        for (int p = 0; p < f; p++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            List<Integer> time = new ArrayList<>();
            List<Integer> low = new ArrayList<>();
            List<Integer> high = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                time.add(scanner.nextInt());
                low.add(scanner.nextInt());
                high.add(scanner.nextInt());
            }

            int min = m;
            int max = m;
            boolean cant = false;
            int x = 0;
            for (int i = 0; i < n; i++) {
                int t = time.get(i) - x;
                x = time.get(i);
                int l = low.get(i);
                int h = high.get(i);

                min = min - t;
                max = max + t;

                if (l > max || h < min) {
                    out.println("NO");
                    cant = true;
                    break;
                }
                min = Math.max(l, min);
                max = Math.min(h, max);
            }
            if (!cant) {
                out.println("YES");
            }
        }

        out.flush();
    }
}
