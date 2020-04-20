package com.codeforces.div3.finished.round535;

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
        Map<Integer, List<Pair<Integer, Integer>>> edgesByWeight = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int w = scanner.nextInt();
            if (!edgesByWeight.containsKey(w)) {
                edgesByWeight.put(w, new ArrayList<>());
            }
            edgesByWeight.get(w).add(new Pair<>(x, y));
        }

        int ans = 0;

        for (int w : edgesByWeight.keySet()) {
            List<Pair<Integer, Integer>> edges = edgesByWeight.get(w);
            Map<Integer, Integer> map = new HashMap<>();
            int x = 0;
            for (Pair<Integer, Integer> edge : edges) {
                int parentX = graph.find(edge.first);
                int parentY = graph.find(edge.second);
                if (parentX != parentY) {
                    if (map.containsKey(parentX)) {
                        map.put(parentY, map.get(parentX));
                    } else if (map.containsKey(parentY)) {
                        map.put(parentX, map.get(parentY));
                    } else {
                        map.put(parentX, x);
                        map.put(parentY, x);
                        x++;
                    }
                }
            }

            Map<Integer, Integer> counter1 = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (!counter1.containsKey(entry.getValue())) {
                    counter1.put(entry.getValue(), 0);
                }
                counter1.put(entry.getValue(), counter1.get(entry.getValue()) + 1);
            }

            Map<Integer, Integer> counter2 = new HashMap<>();
            for (Pair<Integer, Integer> edge : edges) {
                int parentX = graph.find(edge.first);
                int parentY = graph.find(edge.second);
                if (parentX != parentY) {
                    int p = map.get(parentX);
                    if (!counter2.containsKey(p)) {
                        counter2.put(p, 0);
                    }
                    counter2.put(p, counter2.get(p) + 1);
                }
            }

            for (int p : counter1.keySet()) {
                ans = ans + (counter2.get(p) - counter1.get(p) + 1);
            }

            for (Pair<Integer, Integer> edge : edges) {
                int parentX = graph.find(edge.first);
                int parentY = graph.find(edge.second);
                if (parentX != parentY) {
                    graph.union(parentX, parentY);
                }
            }
        }

        out.println(ans);




        out.flush();
    }

    private static class Graph {

        private Map<Integer, Node> nodes = new HashMap<>();

        private Graph(int n) {
            for (int i = 1; i <= n; i++) {
                nodes.put(i, new Node(i));
            }
        }

        private int find(int label) {
            Node node = nodes.get(label);
            while (node.parent != node.label) {
                node = nodes.get(node.parent);
            }
            return node.label;
        }

        private void union(int parentX, int parentY) {
            Node nodeX = nodes.get(parentX);
            Node nodeY = nodes.get(parentY);
            if (nodeX.level < nodeY.level) {
                nodeX.parent = nodeY.label;
            } else if (nodeX.level > nodeY.level) {
                nodeY.parent = nodeX.label;
            } else {
                nodeX.level++;
                nodeY.parent = nodeX.label;
            }
        }
    }

    private static class Node {

        private int label;

        private int parent;

        private int level;

        private Node(int label) {
            this.label = label;
            this.parent = label;
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
