package com.codeforces.div3.finished.round547;

import java.io.*;
import java.util.*;

public class ProblemG {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Tree tree = new Tree(n);
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            tree.addEdge(i, x, y);
        }

        List<Node> nodes = new ArrayList<>(tree.nodes.values());
        Collections.sort(nodes, Comparator.comparingInt(a -> a.adjacents.size()));
        Collections.reverse(nodes);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            set.add(nodes.get(i).label);
        }
        int max = nodes.get(k).adjacents.size();

        int[] ans = new int[n + 1];
        Node root = tree.nodes.get(1);
        LinkedList<Node> toVisit = new LinkedList<>();
        toVisit.add(root);
        while (!toVisit.isEmpty()) {
            Node node = toVisit.poll();
            int color = node.color + 1;
            if (color > max) {
                color = 1;
            }
            for (Pair<Integer, Node> pair : node.adjacents) {
                if (ans[pair.first] == 0) {
                    if (pair.second.label != node.label) {
                        if (set.contains(node.label)) {
                            ans[pair.first] = 1;
                            pair.second.color = 1;
                        } else {
                            ans[pair.first] = color;
                            pair.second.color = color;
                            color++;
                            if (color > max) {
                                color = 1;
                            }
                        }
                        toVisit.add(pair.second);
                    }
                }
            }
        }

        out.println(max);
        for (int i = 0; i < n - 1; i++) {
            out.print(ans[i] + " ");
        }


        out.flush();
    }

    private static class Tree {

        private Map<Integer, Node> nodes = new HashMap<>();

        private Tree(int n) {
            for (int i = 1; i <= n; i++) {
                nodes.put(i, new Node(i));
            }
        }

        private void addEdge(int index, int x, int y) {
            nodes.get(x).adjacents.add(new Pair<>(index, nodes.get(y)));
            nodes.get(y).adjacents.add(new Pair<>(index, nodes.get(x)));
        }
    }

    private static class Node {

        private int label;

        private int color;

        private List<Pair<Integer, Node>> adjacents = new ArrayList<>();

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
}
