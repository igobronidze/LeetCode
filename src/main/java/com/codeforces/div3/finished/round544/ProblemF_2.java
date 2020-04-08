package com.codeforces.div3.finished.round544;

import java.io.*;
import java.util.*;

public class ProblemF_2 {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int d = scanner.nextInt();
        Graph graph = new Graph(n);
        Set<Integer> firstsAdjacents = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (x == 1) {
                firstsAdjacents.add(y);
            } else if (y == 1) {
                firstsAdjacents.add(x);
            } else {
                graph.addEdge(x, y);
            }
        }

        if (firstsAdjacents.size() < d) {
            out.println("NO");
        } else {
            List<List<Integer>> trees = graph.bfs();
            if (trees.size() > d) {
                out.println("NO");
            } else {
                boolean founded = false;
                for (List<Integer> tree : trees) {
                    founded = false;
                    for (int x : tree) {
                        if (firstsAdjacents.contains(x)) {
                            founded = true;
                            graph.addEdge(1, x);
                            firstsAdjacents.remove(x);
                            d--;
                            break;
                        }
                    }
                    if (!founded) {
                        break;
                    }
                }
                if (!founded) {
                    out.println("NO");
                } else {
                    for (int x : firstsAdjacents) {
                        if (d == 0) {
                            break;
                        }
                        graph.addEdge(1, x);
                        d--;
                    }
                    out.println("YES");
                    for (Node node : graph.nodes.values()) {
                        node.visited = false;
                    }
                    for (Pair<Integer, Integer> pair : graph.bfs(1)) {
                        out.println(pair.first + " " + pair.second);
                    }
                }
            }
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

        private List<List<Integer>> bfs() {
            List<List<Integer>> trees = new ArrayList<>();

            for (int i = 2; i <= nodes.size(); i++) {
                if (!nodes.get(i).visited) {
                    List<Integer> tree = new ArrayList<>();
                    LinkedList<Node> toVisit = new LinkedList<>();
                    tree.add(i);
                    Node root = nodes.get(i);
                    root.visited = true;
                    toVisit.add(root);
                    while (!toVisit.isEmpty()) {
                        Node node = toVisit.poll();
                        for (Node adjacent : node.adjacents) {
                            if (!adjacent.visited) {
                                adjacent.visited = true;
                                toVisit.add(adjacent);
                                tree.add(adjacent.label);
                            }
                        }
                    }
                    trees.add(tree);
                }
            }

            return trees;
        }

        private List<Pair<Integer, Integer>> bfs(int rootLabel) {
            List<Pair<Integer, Integer>> edgess = new ArrayList<>();
            LinkedList<Node> toVisit = new LinkedList<>();
            Node root = nodes.get(rootLabel);
            root.visited = true;
            toVisit.add(root);
            while (!toVisit.isEmpty()) {
                Node node = toVisit.poll();
                for (Node adjacent : node.adjacents) {
                    if (!adjacent.visited) {
                        adjacent.visited = true;
                        toVisit.add(adjacent);
                        edgess.add(new Pair<>(node.label, adjacent.label));
                    }
                }
            }

            return edgess;
        }
    }

    private static class Node {

        private int label;

        private List<Node> adjacents = new ArrayList<>();

        private boolean visited;

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

        public Pair() {
        }

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }

    private static class Triple<F, S, T> {

        private F first;

        private S second;

        private T third;

        public Triple() {
        }

        public Triple(F first, S second, T third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}
