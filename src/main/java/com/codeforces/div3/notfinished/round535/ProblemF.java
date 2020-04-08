package com.codeforces.div3.notfinished.round535;

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
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int w = scanner.nextInt();
            graph.addEdge(x, y, w);
        }


        out.println(graph.solve());



        out.flush();
    }

    private static class Graph {

        private Map<Integer, Node> nodes = new HashMap<>();

        private Graph(int n) {
            for (int i = 1; i <= n; i++) {
                nodes.put(i, new Node(i));
            }
        }

        private void addEdge(int x, int y, int w) {
            nodes.get(x).adjacents.add(new Pair<>(nodes.get(y), w));
            nodes.get(y).adjacents.add(new Pair<>(nodes.get(x), w));
        }

        private int solve() {
            int ans = 0;
            PriorityQueue<Pair<Integer, Node>> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.first));

            queue.add(new Pair<>(0, nodes.get(1)));
            nodes.get(1).visited = true;
            while (!queue.isEmpty()) {
                Node node = queue.poll().second;
                node.cost = 0;
                for (Pair<Node, Integer> edge : node.adjacents) {
                    Node adjacent = edge.first;
                    if (adjacent.cost == edge.second) {
                        ans++;
                    } else if (adjacent.cost > edge.second) {
                        queue.add(new Pair<>(edge.second, adjacent));
                        adjacent.cost = edge.second;
                    }
                    if (!adjacent.visited) {
                        queue.add(new Pair<>(edge.second, adjacent));
                        adjacent.visited = true;
                        adjacent.cost = edge.second;
                    }
                }
            }


            return ans;
        }
    }

    private static class Node {

        private int label;

        private List<Pair<Node, Integer>> adjacents = new ArrayList<>();

        private boolean visited;

        private int cost;

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
