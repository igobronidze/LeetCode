package com.codeforces.div3.finished.round629;

import java.io.*;
import java.util.*;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Tree tree = new Tree(n);
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            tree.addEdge(x, y);
        }

        tree.makeTree(1);

        tree.dfs();

        for (int q = 0; q < m; q++) {
            int max = 1;
            List<Integer> nodesToCheck = new ArrayList<>();
            int k = scanner.nextInt();
            for (int i = 0; i < k; i++) {
                int x = scanner.nextInt();
                int level = tree.nodes.get(x).level;
                nodesToCheck.add(x);
                if (level > tree.nodes.get(max).level) {
                    max = x;
                }
            }

            Node last = tree.nodes.get(max);
            boolean cant = false;

            for (int x : nodesToCheck) {
                Node node = tree.nodes.get(x);
                if (x != 1) {
                    Node parent = node.parent;
                    if (parent.t1 > last.t1 || parent.t2 < last.t2) {
                        cant = true;
                        break;
                    }
                }
            }


            if (cant) {
                out.println("NO");
            } else {
                out.println("YES");
            }
        }




        out.flush();
        out.close();
    }

    private static class Tree {

        private Node root;

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
            this.root = nodes.get(rootLabel);
            root.makeTree(root);
        }

        public void dfs() {
            root.dfs(1);
        }
    }

    private static class Node {

        private int label;

        private Node parent;

        private List<Node> children = new ArrayList<>();

        private int level;

        private boolean visited;

        private int t1;

        private int t2;

        private Node(int label) {
            this.label = label;
        }

        private void addChild(Node child) {
            children.add(child);
        }

        private void makeTree(Node parent) {
            this.level = parent.level + 1;
            this.parent = parent;
            for (Node child : getChildren()) {
                child.makeTree(this);
            }
        }

        public List<Node> getChildren() {
            List<Node> result = new ArrayList<>();
            for (Node child : children) {
                if (child.label != parent.label) {
                    result.add(child);
                }
            }
            return result;
        }

        private int dfs(int t) {
            this.t1 = t++;
            for (Node child : children) {
                if (child.t1 == 0) {
                    t = child.dfs(t);
                }
            }
            this.t2 = t++;
            return t;
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
