package com.codeforces.div3.finished.round506;

import java.io.*;
import java.util.*;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        Tree tree = new Tree(n);

        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            tree.addEdge(x, y);
        }

        tree.makeTree(1);

        PriorityQueue<Node> toVisit = new PriorityQueue<>((a, b) -> Integer.compare(b.level, a.level));
        toVisit.addAll(tree.nodes.values());

        int ans = 0;
        while (!toVisit.isEmpty()) {
            Node node = toVisit.poll();
            if (node.level <= 2) {
                break;
            }
            if (node.visited) {
                continue;
            }
            Node parent = node.parent;
            parent.visited = true;
            parent.parent.visited = true;
            for (Node child : parent.children) {
                child.visited = true;
            }
            ans++;
        }

        out.println(ans);

        out.flush();
    }

    private static class Tree {

        private Map<Integer, Node> nodes = new HashMap<>();

        private Tree(int n) {
            for (int i = 1; i <= n; i++) {
                nodes.put(i, new Node(i));
            }
        }

        private void addEdge(int x, int y) {
            nodes.get(x).addChild(nodes.get(y));
            nodes.get(y).addChild(nodes.get(x));
        }

        private void makeTree(int rootLabel) {
            nodes.get(rootLabel).makeTree(nodes.get(rootLabel));
        }
    }

    private static class Node {

        private int label;

        private int level;

        private List<Node> children = new ArrayList<>();

        private Node parent;

        private boolean visited;

        private Node(int label) {
            this.label = label;
        }

        private void addChild(Node child) {
            children.add(child);
        }

        private void makeTree(Node parent) {
            this.parent = parent;
            for (Node child : new ArrayList<>(children)) {
                if (child.label == parent.label) {
                    children.remove(child);
                } else {
                    child.level = this.level + 1;
                    child.makeTree(this);
                }
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

        public Pair() {}

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
