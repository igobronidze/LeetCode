package com.codeforces.div2.round601;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class ProblemC {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    private static Map<String, List<Integer>> map = new HashMap<>();

    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        n = scanner.nextInt();
        ArrayList<Pair<Integer, Integer>>[] array = new ArrayList[n + 1];

        for (int i = 0; i < n - 2; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            if (array[a] == null) {
                array[a] = new ArrayList<>();
            }
            array[a].add(new Pair<>(b, c));

            if (array[b] == null) {
                array[b] = new ArrayList<>();
            }
            array[b].add(new Pair<>(a, c));

            if (array[c] == null) {
                array[c] = new ArrayList<>();
            }
            array[c].add(new Pair<>(a, b));
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < array.length; i++) {
            if (array[i].size() == 1) {
                ans.add(i);

                int f = array[i].get(0).first;
                int s = array[i].get(0).second;

                int second;
                int third;
                if (array[f].size() == 2) {
                    second = f;
                    third = s;
                } else {
                    second = s;
                    third = f;
                }

                ans.add(second);
                ans.add(third);
                while (ans.size() != n) {
                    int x = ans.get(ans.size() - 3);
                    int y = ans.get(ans.size() - 2);
                    int z = ans.get(ans.size() - 1);
                    for (Pair<Integer, Integer> pair : array[z]) {
                        if (pair.first == y || pair.second == y) {
                            if (pair.first != x && pair.second != x) {
                                if (pair.first == y) {
                                    ans.add(pair.second);
                                } else {
                                    ans.add(pair.first);
                                }
                                break;
                            }
                        }
                    }
                }
                break;
            }
        }

        printList(ans, out);


        out.flush();
    }

    private static void printList(List<Integer> list, PrintWriter out) {
        for (int x : list) {
            out.print(x + " ");
        }
    }

    private static class Pair<F, S> {

        private F first;

        private S second;

        public Pair() {
        }

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
