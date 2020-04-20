package com.codeforces.div3.finished.round575;

import java.io.*;
import java.util.*;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    private static int k;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        k = scanner.nextInt();
        Graph graph = new Graph(n);
        List<Triple<Integer, Integer, Integer>> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int w = scanner.nextInt();
            graph.addEdge(x, y, w);
            edges.add(new Triple<>(x, y, w));
        }
        Collections.sort(edges, Comparator.comparingInt(edge -> edge.third));
        graph.sort();

        PriorityQueue<Long> smallestPathes = new PriorityQueue<>((l1, l2) -> Long.compare(l2, l1));
        Set<Integer> notInclude = new HashSet<>();
        for (int i = 0; i < edges.size(); i++) {
            int x = edges.get(i).first;
            int y = edges.get(i).first;
            if (!notInclude.contains(x)) {
                notInclude.add(x);
                List<Long> pathes = graph.getMinPathes(x, notInclude, smallestPathes.size() == k ? smallestPathes.peek() : Long.MAX_VALUE);
                for (Long path : pathes) {
                    smallestPathes.add(path);
                    if (smallestPathes.size() > k) {
                        smallestPathes.poll();
                    }
                }
            }
            if (!notInclude.contains(y)) {
                notInclude.add(y);
                List<Long> pathes = graph.getMinPathes(y, notInclude, smallestPathes.size() == k ? smallestPathes.peek() : Long.MAX_VALUE);
                for (Long path : pathes) {
                    smallestPathes.add(path);
                    if (smallestPathes.size() > k) {
                        smallestPathes.poll();
                    }
                }
            }

            if (notInclude.size() >= k ) {
                break;
            }
        }

        out.println(smallestPathes.poll());



        out.flush();
    }

    private static class Graph {

        private Map<Integer, Node> nodes = new HashMap<>();

        private Graph(int n) {
            for (int i = 1; i <= n; i++) {
                nodes.put(i, new Node(i));
            }
        }

        private void sort() {
            for (Node node : nodes.values()) {
                Collections.sort(node.adjacents, Comparator.comparingInt(pair -> pair.second));
            }
        }

        private void addEdge(int x, int y, int w) {
            nodes.get(x).adjacents.add(new Pair<>(nodes.get(y), w));
            nodes.get(y).adjacents.add(new Pair<>(nodes.get(x), w));
        }

        private void clean() {
            nodes.values().forEach(node -> node.visited = false);
        }

        private List<Long> getMinPathes(int rootLabel, Set<Integer> notInclude, long minPath) {
            clean();

            List<Long> pathes = new ArrayList<>();
            PriorityQueue<Pair<Long, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(pair -> pair.first));
            priorityQueue.add(new Pair<>(0L, rootLabel));
            while (!priorityQueue.isEmpty() && pathes.size() != k) {
                Pair<Long, Integer> pair = priorityQueue.poll();
                Node node = nodes.get(pair.second);
                if (!node.visited) {
                    node.visited = true;
                    if (pair.first < minPath) {
                        if (!notInclude.contains(node.label)) {
                            pathes.add(pair.first);
                        }
                        int f = 0;
                        for (Pair<Node, Integer> edge : node.adjacents) {
                            Node adjacent = edge.first;
                            if (!adjacent.visited) {
                                priorityQueue.add(new Pair<>(pair.first + edge.second, adjacent.label));
                            }
                            f++;
                            if (f > k) {
                                break;
                            }
                        }
                    }
                }
            }
            return pathes;
        }
    }

    private static class Node {

        private int label;

        boolean visited;

        private List<Pair<Node, Integer>> adjacents = new ArrayList<>();

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