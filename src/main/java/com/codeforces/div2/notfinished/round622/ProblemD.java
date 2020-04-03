package com.codeforces.div2.notfinished.round622;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        LinkedList<Node> nodesFromLeft = new LinkedList<>();
        List<Long> dpFromLeft = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Node node = new Node(list.get(i), i);
            boolean setDp = false;
            while (!nodesFromLeft.isEmpty()) {
                Node last = nodesFromLeft.peekLast();
                if (last.value <= node.value) {
                    node.dp = last.dp + (long) (i - last.index) * node.value;
                    setDp = true;
                    break;
                } else {
                    nodesFromLeft.pollLast();
                }
            }
            if (!setDp) {
                node.dp = (long) (i + 1) * list.get(i);
            }

            nodesFromLeft.add(node);
            dpFromLeft.add(node.dp);
        }


        LinkedList<Node> nodesFromRight = new LinkedList<>();
        List<Long> dpFromRight = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            Node node = new Node(list.get(i), i);
            boolean setDp = false;
            while (!nodesFromRight.isEmpty()) {
                Node last = nodesFromRight.peekLast();
                if (last.value <= node.value) {
                    node.dp = last.dp + (long) (last.index - i) * node.value;
                    setDp = true;
                    break;
                } else {
                    nodesFromRight.pollLast();
                }
            }
            if (!setDp) {
                node.dp = (long) (n - i) * list.get(i);
            }

            nodesFromRight.add(node);
            dpFromRight.add(node.dp);
        }


        int index = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            if ((long) dpFromLeft.get(i) + dpFromRight.get(n - i - 1) - list.get(i) > max) {
                max = (long) dpFromLeft.get(i) + dpFromRight.get(n - i - 1) - list.get(i);
                index = i;
            }
        }

        int[] ans = new int[n + 1];

        int min = list.get(index);
        for (int i = index; i >= 0; i--) {
            if (list.get(i) > min) {
                ans[i] = min;
            } else {
                ans[i] = list.get(i);
                min = list.get(i);
            }
        }

        min = list.get(index);
        for (int i = index + 1; i < n; i++) {
            if (list.get(i) > min) {
                ans[i] = min;
            } else {
                ans[i] = list.get(i);
                min = list.get(i);
            }
        }

        for (int i = 0; i < n; i++) {
            out.print(ans[i] + " ");
        }


        out.flush();
    }

    private static class Node implements Comparable<Node> {

        int value;

        int index;

        long dp;

        private Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Node node) {
            int x = Integer.compare(value, node.value);
            if (x != 0) {
                return x;
            }
            return Integer.compare(index, node.index);
        }
    }
}
