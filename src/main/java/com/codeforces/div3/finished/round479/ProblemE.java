package com.codeforces.div3.finished.round479;

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
        Graph graph = new Graph(n);
        for (int i = 0; i < m; i++) {
            graph.addEdge(scanner.nextInt(), scanner.nextInt());
        }

        out.println(graph.solve());



        out.flush();
    }

    private static class Graph {

        private Map<Integer, Node> nodes =  new HashMap<>();

        private Graph(int n) {
            for (int i = 1; i <= n; i++) {
                nodes.put(i, new Node(i));
            }
        }

        private void addEdge(int x, int y) {
            nodes.get(x).adjacenst.add(nodes.get(y));
            nodes.get(y).adjacenst.add(nodes.get(x));
        }

        private int solve() {
            int ans = 0;
            for (Node root : nodes.values()) {
                if (!root.visited) {
                    List<Node> path = new ArrayList<>();
                    LinkedList<Node> toVisit = new LinkedList<>();
                    root.visited = true;
                    toVisit.add(root);
                    while (!toVisit.isEmpty()) {
                        Node node = toVisit.poll();
                        path.add(node);
                        for (Node adjacent : node.adjacenst) {
                            if (!adjacent.visited) {
                                adjacent.visited = true;
                                toVisit.add(adjacent);
                            }
                        }
                    }
                    boolean isCycle = true;
                    for (Node node : path) {
                        if (node.adjacenst.size() != 2) {
                            isCycle = false;
                        }
                    }
                    if (isCycle) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }

    private static class Node {

        private int label;

        private boolean visited;

        private List<Node> adjacenst = new ArrayList<>();

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
