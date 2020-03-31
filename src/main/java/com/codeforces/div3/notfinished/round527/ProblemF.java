package com.codeforces.div3.notfinished.round527;

import java.io.*;
import java.util.*;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();

        int[] values = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            values[i] = scanner.nextInt();
        }

        Tree tree = new Tree(n, values);
        for (int i = 0; i < n - 1; i++ ){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            tree.addEdge(x, y);
        }
        tree.makeTree(1);
        tree.specifySumAndCostForTree();

        out.println(tree.solve());

        out.flush();
    }

    private static class Tree {

        private Node root;

        private Map<Integer, Node> nodes = new HashMap<>();

        private Tree(int n, int[] values) {
            for (int i = 1; i <= n; i++) {
                nodes.put(i, new Node(i, values[i]));
            }
        }

        private void addEdge(int x, int y) {
            nodes.get(x).addChild(nodes.get(y));
            nodes.get(y).addChild(nodes.get(x));
        }

        private void makeTree(int rootLabel) {
            root = nodes.get(rootLabel);
            nodes.get(rootLabel).makeTree(nodes.get(rootLabel));
        }

        private void specifySumAndCostForTree() {
            root.specifySumAndCost();
        }

        private long solve() {
            return root.reRoot();
        }
    }

    private static class Node {

        private int label;

        private int value;

        private long sum;

        private long cost;

        private List<Node> children = new ArrayList<>();

        private Node parent;

        private Node(int label, int value) {
            this.label = label;
            this.value = value;
        }

        private void addChild(Node child) {
            children.add(child);
        }

        private void makeTree(Node parent) {
            this.parent = parent;
            for (Node node : new ArrayList<>(children)) {
                if (node.label == parent.label) {
                    children.remove(node);
                } else {
                    node.makeTree(this);
                }
            }
        }

        private void specifySumAndCost() {
            for (Node child : children) {
                child.specifySumAndCost();
            }
            long sum = 0;
            long cost = 0;
            for (Node child : children) {
                sum += child.sum + child.value;
                cost += child.cost;
            }
            this.sum = sum;
            this.cost = cost + sum;
        }

        private long reRoot() {
            long max = cost;
            for (Node child : children) {
                long thisCost = cost;
                long thisSum = sum;
                long childCost = child.cost;
                long childSum = child.sum;

                this.cost -= (child.cost + child.sum + child.value);
                this.sum -= (child.sum + child.value);
                child.sum += this.sum + this.value;
                child.cost += this.cost + this.sum + this.value;
                max = Math.max(max, child.cost);
                max = Math.max(max, child.reRoot());

                cost = thisCost;
                sum = thisSum;
                child.cost = childCost;
                child.sum = childSum;
            }

            return max;
        }
    }

    private static class MyScanner {
        private BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        private MyScanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        private String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }

        private String nextLine() {
            String str = "";
            try {
                str = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
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
