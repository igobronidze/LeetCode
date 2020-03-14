package com.codeforces.round627;

import java.io.*;
import java.util.*;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        boolean[] colors = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (x == 1) {
                colors[i + 1] = true;
            }
        }

        Tree tree = new Tree(n, colors);
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            tree.addEde(x, y);
        }
        tree.makeTree(1);

        tree.specifyNodesInitialValues();

        Map<Integer, Integer> ans = new HashMap<>();
        ans.put(1, tree.nodes.get(1).value);

        tree.solve(tree.root, ans);

        for (int i = 1; i <= n; i++) {
            out.print(ans.get(i) + " ");
        }


        out.flush();
    }

    private static class Tree {

        private Node root;

        private Map<Integer, Node> nodes;

        private Tree(int n, boolean[] colors) {
            this.nodes = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                nodes.put(i, new Node(i, colors[i]));
            }
        }

        private void addEde(int x, int y) {
            nodes.get(x).addChild(nodes.get(y));
            nodes.get(y).addChild(nodes.get(x));
        }

        private void makeTree(int r) {
            root = nodes.get(r);
            root.specifyParent(root);
        }

        private void specifyNodesInitialValues() {
            root.specifyValue();
        }

        private void solve(Node node, Map<Integer, Integer> ans) {
            for (Node child : node.children) {
                int x = node.value;
                int y = child.value;
                if (child.value > 0) {
                    node.value -= child.value;
                }
                if (node.value > 0) {
                    child.value += node.value;
                }
                ans.put(child.label, child.value);
                solve(child, ans);
                node.value = x;
                child.value = y;
            }
        }
    }

    private static class Node {

        private int label;

        private boolean color;

        private int value;

        private Node parent;

        private List<Node> children;

        private Node(int label, boolean color) {
            this.label = label;
            this.color = color;
            this.children = new ArrayList<>();
        }

        private void addChild(Node child) {
            this.children.add(child);
        }

        private void specifyParent(Node parent) {
            this.parent = parent;
            for (Node child : new ArrayList<>(children)) {
                if (child.label != parent.label) {
                    child.specifyParent(this);
                } else {
                    children.remove(child);
                }
            }
        }

        private void specifyValue() {
            for (Node child : children) {
                child.specifyValue();
                if (child.value > 0) {
                    value += child.value;
                }
            }
            if (color) {
                value++;
            } else {
                value--;
            }
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

        public Pair() {
        }

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
