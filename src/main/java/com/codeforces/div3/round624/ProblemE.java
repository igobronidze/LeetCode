package com.codeforces.div3.round624;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class ProblemE {

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

            int sum = n * (n - 1) / 2;

            LinkedList<Node> leafs = new LinkedList<>();
            Map<Integer, Set<Node>> nodes = new HashMap<>();
            Node last = null;
            for (int i = 1; i <= n; i++) {
                Node node = new Node(i, i - 1, last, i == n ? 0 : 1);
                last = node;
                nodes.put(i - 1, new HashSet<>());
                nodes.get(i - 1).add(node);
                if (i == n) {
                    leafs.add(node);
                }
            }

            boolean cant = false;
            while (sum != d) {
                boolean founded = false;
                for (Node leaf : new ArrayList<>(leafs)) {
                    if (nodes.containsKey(leaf.depth - 2)) {
                        for (Node node : new ArrayList<>(nodes.get(leaf.depth - 2))) {
                            if (node.numberOfChild != 2) {
                                nodes.get(leaf.depth).remove(leaf);
                                nodes.get(leaf.depth - 1).add(leaf);
                                node.numberOfChild++;
                                leaf.depth = node.depth + 1;
                                if (leaf.parent != null) {
                                    leaf.parent.numberOfChild--;
                                    if (leaf.parent.numberOfChild == 0) {
                                        leafs.add(leaf.parent);
                                    }
                                }
                                leaf.parent = node;
                                founded = true;
                                break;
                            }
                        }
                    }
                    if (founded) {
                        break;
                    }
                }
                if (!founded) {
                    cant = true;
                    break;
                }
                sum--;
            }

            if (!cant) {
                Map<Integer, Integer> parents = new TreeMap<>();
                for (Set<Node> list : nodes.values()) {
                    for (Node node : list) {
                        if (node.label != 1) {
                            parents.put(node.label, node.parent.label);
                        }
                    }
                }
                out.println("YES");
                for (int x : parents.values()) {
                    out.print(x + " ");
                }
                out.println();
            } else {
                out.println("NO");
            }
        }
        out.flush();
    }

    private static class Node {

        private int label;

        private int depth;

        private Node parent;

        private int numberOfChild;

        private Node(int label, int depth, Node parent, int numberOfChild) {
            this.label = label;
            this.depth = depth;
            this.parent = parent;
            this.numberOfChild = numberOfChild;
        }
    }
}
