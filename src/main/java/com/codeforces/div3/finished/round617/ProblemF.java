package com.codeforces.div3.finished.round617;

import java.io.*;
import java.util.*;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        Graph graph = new Graph(n);
        List<Pair<Integer, Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph.addEdge(x, y);
            edges.add(new Pair<>(x, y));
        }

        int m = scanner.nextInt();
        List<Pair<Pair<Integer, Integer>, Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int w = scanner.nextInt();
            list.add(new Pair<>(new Pair<>(x, y), w));
        }

        Collections.sort(list, (a, b) -> Integer.compare(b.second, a.second));

        boolean can = true;
        for (Pair<Pair<Integer, Integer>, Integer> pair : list) {
            can = can & graph.fillF(pair.first.first, pair.first.second, pair.second);
        }

        if (!can) {
            out.print(-1);
        } else {
            for (Pair<Integer, Integer> edge : edges) {
                int a = Math.min(edge.first, edge.second);
                int b = Math.max(edge.first, edge.second);
                int x = graph.f[a][b];
                if (x == 0) {
                    out.print(1_000_000 + " ");
                } else {
                    out.print(x + " ");
                }
            }
        }





        out.flush();
    }

    private static class Graph {

        private Map<Integer, Node> nodes = new HashMap<>();

        private int[][] f;

        private Graph(int n) {
            for (int i = 1; i <= n; i++) {
                nodes.put(i, new Node(i));
            }
            f = new int[n + 1][n + 1];
        }

        private void addEdge(int x, int y) {
            nodes.get(x).adjacents.add(nodes.get(y));
            nodes.get(y).adjacents.add(nodes.get(x));
        }

        private boolean fillF(int x, int y, int w) {
            for (Node node : nodes.values()) {
                node.clean();
            }

            LinkedList<Node> toVisit = new LinkedList<>();
            toVisit.add(nodes.get(x));
            while (!toVisit.isEmpty()) {
                Node node = toVisit.poll();
                node.visited = true;
                if (node.label == y) {
                    break;
                }
                for (Node adjacent : node.adjacents) {
                    if (!adjacent.visited) {
                        adjacent.from = node;
                        adjacent.visited = true;
                        toVisit.add(adjacent);
                    }
                }
            }

            Node dest = nodes.get(y);
            boolean found = false;
            while (dest.from != null) {
                int a = Math.min(dest.label, dest.from.label);
                int b = Math.max(dest.label, dest.from.label);
                if (f[a][b] == 0 || f[a][b] == w) {
                    f[a][b] = w;
                    found = true;
                }
                dest = dest.from;
            }

            return found;
        }
    }

    private static class Node {

        private int label;

        private List<Node> adjacents = new ArrayList<>();

        private boolean visited;

        private Node from;

        private Node(int label) {
            this.label = label;
        }

        private void clean() {
            visited = false;
            from = null;
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
