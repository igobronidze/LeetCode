package com.codeforces;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Templates {

    private static void readT(Scanner scanner) {
        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {

        }
    }

    private static void readNAndList(Scanner scanner) {
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
    }

    private static void printList(List<Integer> list, PrintWriter out) {
        for (int x : list) {
            out.print(x + " ");
        }
        out.println();
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
