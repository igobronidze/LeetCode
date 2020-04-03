package com.codeforces.div3.finished.round565;

import java.io.*;
import java.util.*;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            Graph graph = new Graph(n);
            for (int i = 0; i < m; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                graph.addEdge(x, y);
            }

            int maxLevel = graph.bfs(1);

            List<Integer> odds = new ArrayList<>();
            List<Integer> evens = new ArrayList<>();
            for (Node node : graph.nodes.values()) {
                if (node.level % 2 == 0) {
                    evens.add(node.label);
                } else {
                    odds.add(node.label);
                }
            }

            List<Integer> ans = new ArrayList<>();
            if (odds.size() > evens.size()) {
                ans = new ArrayList<>(evens);
            } else {
                ans = new ArrayList<>(odds);
            }

            out.println(ans.size());
            for (int x : ans) {
                out.print(x + " ");
            }
            out.println();
        }

        out.flush();
    }

    private static class Graph {

        private Map<Integer, Node> nodes = new HashMap<>();

        private Graph(int n) {
            for (int i = 1; i <= n; i++) {
                nodes.put(i, new Node(i));
            }
        }

        private void addEdge(int x, int y) {
            nodes.get(x).adjacents.add(nodes.get(y));
            nodes.get(y).adjacents.add(nodes.get(x));
        }

        private int bfs(int rootLabel) {
            int maxLevel = 1;

            Node root = nodes.get(rootLabel);
            root.level = 1;
            root.visited = true;
            LinkedList<Node> toVisit = new LinkedList<>();
            toVisit.add(root);
            while (!toVisit.isEmpty()) {
                Node node = toVisit.poll();
                for (Node adjacent : node.adjacents) {
                    if (!adjacent.visited) {
                        adjacent.visited = true;
                        adjacent.level = node.level + 1;
                        toVisit.add(adjacent);

                        maxLevel = Math.max(maxLevel, adjacent.level);
                    }
                }
            }

            return maxLevel;
        }
    }

    private static class Node {

        private int label;

        private boolean visited;

        private int level;

        private List<Node> adjacents = new ArrayList<>();

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
