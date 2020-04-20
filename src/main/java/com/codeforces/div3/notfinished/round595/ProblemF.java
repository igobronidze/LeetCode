package com.codeforces.div3.notfinished.round595;

import java.io.*;
import java.util.*;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> costs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            costs.add(scanner.nextInt());
        }
        Graph graph = new Graph(n, costs);
        for (int i = 0; i < n - 1; i++) {
            graph.addEdge(scanner.nextInt(), scanner.nextInt());
        }

        int diameterVertex = graph.getDiameterVertex();
        graph.clean();

        graph.dfs(diameterVertex);



        out.flush();
    }

    private static class Graph {

        private Map<Integer, Node> nodes = new HashMap<>();

        private Map<Integer, List<Node>> levelNodesMap = new HashMap<>();

        private Graph(int n, List<Integer> costs) {
            for (int i = 1; i <= n; i++) {
                nodes.put(i, new Node(i, costs.get(i - 1)));
            }
        }

        private void addEdge(int x, int y) {
            nodes.get(x).children.add(nodes.get(y));
            nodes.get(y).children.add(nodes.get(x));
        }

        private int getDiameterVertex() {
            Node root = nodes.get(1);
            root.dfs(root);
            int maxLevelLabel = 1;
            for (Node node : nodes.values()) {
                if (node.level > nodes.get(maxLevelLabel).level) {
                    maxLevelLabel = node.label;
                }
            }
            return maxLevelLabel;
        }

        private void clean() {
            for (Node node : nodes.values()) {
                node.level = 0;
            }
        }

        private void dfs(int rootLabel) {
            Node root = nodes.get(rootLabel);
            root.dfs(root);
        }

        private void initLevelNodesMap() {
            for (Node node : nodes.values()) {
                if (!levelNodesMap.containsKey(node.level)) {

                }
            }
        }
    }

    private static class Node {

        private int label;

        private int cost;

        private int maxSubTreeCost;

        private int level;

        private List<Node> children = new ArrayList<>();

        private Node(int label, int cost) {
            this.label = label;
            this.cost = cost;
        }

        private void dfs(Node parent) {
            for (Node child : children) {
                if (child.label != parent.label) {
                    child.level = parent.level + 1;
                    child.dfs(this);
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

    private static class Triple<F, S, T> {

        private F first;

        private S second;

        private T third;

        public Triple() {}

        public Triple(F first, S second, T third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}
