package com.codeforces.div3.round611;

import java.io.*;
import java.util.*;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            list.add(scanner.nextInt());
        }

        boolean[] visited = new boolean[n + 1];

        int last = list.get(0);
        visited[last] = true;
        Tree tree = new Tree(n);

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            treeSet.add(i);
        }
        treeSet.remove(last);
        for (int i = 1; i < n - 1; i++) {
            int x = list.get(i);
            if (visited[x]) {
                int p = treeSet.last();
                visited[p] = true;
                treeSet.remove(p);
                tree.addEdge(last, p);
            } else {
                tree.addEdge(last, x);
            }
            treeSet.remove(x);
            visited[x] = true;
            last = x;
        }

        tree.addEdge(last, treeSet.last());

        out.println(list.get(0));
        for (Node node : tree.nodes.values()) {
            for (Node child : node.children) {
                out.println(node.label + " " + child.label);
            }
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

        private void addNode(int label) {
            nodes.put(label, new Node(label));
        }

        private void addEdge(int x, int y) {
            nodes.get(x).children.add(nodes.get(y));
        }
    }

    private static class Node {

        private int label;

        private List<Node> children = new ArrayList<>();

        private Node(int label) {
            this.label = label;
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
