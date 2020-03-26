package com.codeforces.div3.round624;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class ProblemB {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            List<Pair<Integer, Integer>> pairList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                pairList.add(new Pair<>(scanner.nextInt(), i));
            }
            Set<Integer> pSet = new HashSet<>();
            for (int i = 0; i < m; i++) {
                pSet.add(scanner.nextInt());
            }

            pairList.sort(Comparator.comparingInt((Pair<Integer, Integer> t3) -> t3.first).thenComparingInt(t3 -> t3.second));

            boolean cant = false;
            for (int i = 0; i < n; i++) {
                if (i < pairList.get(i).second) {
                    for (int j = i; j < pairList.get(i).second; j++) {
                        if (!pSet.contains(j + 1)) {
                            out.println("NO");
                            cant = true;
                            break;
                        }
                    }
                }
                if (cant) {
                    break;
                }
            }
            if (!cant) {
                out.println("YES");
            }
        }

        out.flush();
    }

    private static class Pair<F, S> {

        private F first;

        private S second;

        public Pair() {}

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
