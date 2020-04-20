package com.codeforces.div3.notfinished.round550;

import java.io.*;
import java.util.*;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Graph graph = new Graph(n);
        List<Pair<Integer, Integer>> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph.addEdge(x, y);
            edges.add(new Pair<>(x, y));
        }

        if (graph.color(1)) {
            out.println("NO");
        } else {
            out.println("YES");
            for (Pair<Integer, Integer> edge : edges) {
                out.print(graph.nodes.get(edge.first).color - 1);
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

        private boolean color(int rootLabel) {
            Node root = nodes.get(rootLabel);
            root.color = 1;
            LinkedList<Node> toVisit = new LinkedList<>();
            toVisit.addFirst(root);
            boolean cant = false;
            while (!toVisit.isEmpty()) {
                Node node = toVisit.poll();
                for (Node adjacent : node.adjacents) {
                    if (adjacent.color == 0) {
                        if (node.color == 1) {
                            adjacent.color = 2;
                        } else {
                            adjacent.color = 1;
                        }
                        toVisit.addFirst(adjacent);
                    } else {
                        if (node.color == adjacent.color) {
                            cant = true;
                            break;
                        }
                    }
                }
            }

            return cant;
        }
    }

    private static class Node {

        private int label;

        private int color;

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
