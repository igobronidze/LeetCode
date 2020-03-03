package com.codeforces.ozon_tech_challenge_2020;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        Set<Pair> pairs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            pairs.add(new Pair(Math.min(x, y), Math.max(x, y)));
        }

        int x = 1;
        int y = 2;
        while (y < n) {
            if (!pairs.contains(new Pair(x, y))) {
                out.println("? " + x + " " + y);
                int z = scanner.nextInt();
                if (z != x && z != y) {
                    x = z;
                } else if (x == z) {

                }
            } else {
                y++;
            }
        }


        out.flush();
    }

    private static class Pair {

        private Integer first;

        private Integer second;

        public Pair() {
        }

        public Pair(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }

        public Integer getFirst() {
            return first;
        }

        public void setFirst(Integer first) {
            this.first = first;
        }

        public Integer getSecond() {
            return second;
        }

        public void setSecond(Integer second) {
            this.second = second;
        }
    }
}
