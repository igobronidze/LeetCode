package com.codeforces.other.ozon_tech_challenge_2020;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();

        Map<Integer, ArrayList<Integer>> tree = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (!tree.containsKey(x)) {
                tree.put(x, new ArrayList<>());
            }
            if (!tree.containsKey(y)) {
                tree.put(y, new ArrayList<>());
            }
            tree.get(x).add(y);
            tree.get(y).add(x);
        }

        LinkedList<Integer> leaves = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (tree.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (true) {
            int x = leaves.poll();
            int y = leaves.poll();

            out.println("? " + x + " " + y);
            out.flush();
            int a = scanner.nextInt();
            if (a == x || a == y || leaves.isEmpty()) {
                out.println("! " + a);
                out.flush();
                break;
            }
            int p = tree.get(x).get(0);
            int q = tree.get(y).get(0);

            tree.get(p).remove(Integer.valueOf(x));
            tree.get(q).remove(Integer.valueOf(y));

            if (tree.get(p).size() == 1) {
                leaves.add(p);
            }
            if (p != q && tree.get(q).size() == 1) {
                leaves.add(q);
            }
        }

    }
}
