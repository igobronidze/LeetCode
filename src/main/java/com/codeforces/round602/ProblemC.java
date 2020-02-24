package com.codeforces.round602;

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
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair<>(scanner.nextInt(), i));
        }
        pairs.sort((t1, t2) -> {
            int x = Integer.compare(t2.first, t1.first);
            if (x != 0) {
                return x;
            }
            return Integer.compare(t1.second, t2.second);
        });

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int k = scanner.nextInt();
            int p = scanner.nextInt();

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
