package com.codeforces.div3.finished.round490;

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
        int c = scanner.nextInt();

        Graph graph = new Graph(n);
        for (int i = 0; i < m; i++) {
            graph.addEdge(scanner.nextInt(), scanner.nextInt());
        }

        out.print(graph.solve(c));


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
        }

        private int solve(int c) {
            Node root = nodes.get(c);
            LinkedList<Node> toVisit = new LinkedList<>();
            root.visited = true;
            toVisit.add(root);
            while (!toVisit.isEmpty()) {
                Node node = toVisit.poll();
                for (Node adjacent : node.adjacents) {
                    if (!adjacent.visited) {
                        adjacent.visited = true;
                        toVisit.add(adjacent);
                    }
                }
            }

            List<Pair<Integer, Integer>> pairs = new ArrayList<>();
            boolean[] visits = new boolean[nodes.size() + 1];
            for (Node node : nodes.values()) {
                visits[node.label] = node.visited;
            }

            for (Node r : nodes.values()) {
                if (!r.visited) {
                    int x = 0;
                    toVisit = new LinkedList<>();
                    r.visited = true;
                    toVisit.add(r);
                    while (!toVisit.isEmpty()) {
                        Node node = toVisit.poll();
                        x++;
                        for (Node adjacent : node.adjacents) {
                            if (!adjacent.visited) {
                                adjacent.visited = true;
                                toVisit.add(adjacent);
                            }
                        }
                    }
                    pairs.add(new Pair<>(x, r.label));

                    for (int j = 1; j <= nodes.size(); j++) {
                        nodes.get(j).visited = visits[j];
                    }
                }
            }

            Collections.sort(pairs, (a, b) -> Integer.compare(b.first, a.first));

            int ans = 0;
            for (Pair<Integer, Integer> pair : pairs) {
                Node r = nodes.get(pair.second);
                if (!r.visited) {
                    ans++;
                    toVisit = new LinkedList<>();
                    r.visited = true;
                    toVisit.add(r);
                    while (!toVisit.isEmpty()) {
                        Node node = toVisit.poll();
                        for (Node adjacent : node.adjacents) {
                            if (!adjacent.visited) {
                                adjacent.visited = true;
                                toVisit.add(adjacent);
                            }
                        }
                    }
                }
            }


            return ans;
        }
    }

    private static class Node {

        private int label;

        private boolean visited;

        private List<Node> adjacents = new ArrayList<>();

        private Node(int label){
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
