package com.codeforces.div3.round615;

import java.io.*;
import java.util.*;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();

        Tree tree1 = new Tree(n);
        Tree tree2 = new Tree(n);
        Tree tree3 = new Tree(n);
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            tree1.addEdge(x, y);
            tree2.addEdge(x, y);
            tree3.addEdge(x, y);
        }

        int s = 0;

        tree1.makeTree(1);
        tree1.bfs(Collections.singletonList(1));
        int x = tree1.getFarthestNode();

        tree2.makeTree(x);
        tree2.bfs(Collections.singletonList(x));
        int y = tree2.getFarthestNode();
        s += tree2.nodes.get(y).dist;
        if (s == n) {
            out.println(n - 1);
            out.print(x + " " + y + " ");
            for (int i = 1; i <= n; i++) {
                if (i != x && i != y) {
                    out.print(i);
                    break;
                }
            }
        } else {
            List<Integer> list = new ArrayList<>();
            Node yNode = tree2.nodes.get(y);
            while (yNode != null) {
                list.add(yNode.label);
                yNode = yNode.adj;
            }

            tree3.makeTree(y);
            tree3.bfs(list);
            int z = tree3.getFarthestNode();
            s += tree3.nodes.get(z).dist - 1;

            out.println(s - 1);
            out.println(x + " " + y + " " + z);
        }


        out.flush();
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
            root = nodes.get(rootLabel);
            root.makeTree(rootLabel);
        }

        private void bfs(List<Integer> initialNodes) {
            LinkedList<Node> toVisit = new LinkedList<>();
            for (int x : initialNodes) {
                Node node = nodes.get(x);
                node.dist = 1;
                toVisit.add(node);
            }

            while (!toVisit.isEmpty()) {
                Node node = toVisit.poll();
                for (Node child : node.children) {
                    if (child.dist == 0) {
                        child.dist = node.dist + 1;
                        toVisit.add(child);
                        child.adj = node;
                    }
                }
            }
        }

        private int getFarthestNode() {
            int x = 1;
            for (int i = 2; i <= nodes.size(); i++) {
                if (nodes.get(i).dist > nodes.get(x).dist) {
                    x = i;
                }
            }
            return x;
        }
    }

    private static class Node {

        private int label;

        private int dist;

        private List<Node> children = new ArrayList<>();

        private Node adj;

        private Node(int label) {
            this.label = label;
        }

        private void addChild(Node child) {
            children.add(child);
        }

        private void makeTree(int parent) {
            for (Node child : new ArrayList<>(children)) {
                if (child.label == parent) {
                    children.remove(child);
                } else {
                    child.makeTree(this.label);
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

        public Pair() {
        }

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
