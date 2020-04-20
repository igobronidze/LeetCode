package com.codeforces.div3.finished.round582;

import java.io.*;
import java.util.*;

public class ProblemG {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Triple<Integer, Integer, Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int w = scanner.nextInt();
            edges.add(new Triple<>(x, y, w));
        }

        Collections.sort(edges, Comparator.comparingInt(a -> a.third));

        List<Pair<Integer, Integer>> queries = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            queries.add(new Pair<>(scanner.nextInt(), i));
        }
        Collections.sort(queries, Comparator.comparingInt(a -> a.first));

        long[] ans = new long[m + 1];
        int index = 0;
        long s = 0;
        DSU dsu = new DSU(n);
        for (int i = 0; i < m; i++) {
            Pair<Integer, Integer> query = queries.get(i);
            while (index < n - 1 && edges.get(index).third <= query.first) {
                s = s + dsu.union(edges.get(index).first, edges.get(index).second);
                index++;
            }
            ans[query.second] = s;
        }


        for (int i = 0; i < m; i++) {
            out.print(ans[i] + " ");
        }


        out.flush();
    }

    private static class DSU {

        private Map<Integer, Node> nodes = new HashMap<>();

        private DSU(int n) {
            for (int i = 1; i <= n; i++) {
                nodes.put(i, new Node(i));
            }
        }

        private long union(int x, int y) {
            int xParent = find(x);
            int yParent = find(y);
            if (xParent == yParent) {
                return 0;
            }
            Node xNode = nodes.get(xParent);
            Node yNode = nodes.get(yParent);
            long s = (long) xNode.count * yNode.count;
            if (xNode.rank > yNode.rank) {
                yNode.parent = xNode.label;
                xNode.count += yNode.count;
            } else {
                if (xNode.rank == yNode.rank) {
                    yNode.rank++;
                }
                xNode.parent = yNode.label;
                yNode.count += xNode.count;
            }
            return s;
        }

        private int find(int n) {
            Node node = nodes.get(n);
            while (node.parent != node.label) {
                node = nodes.get(node.parent);
            }
            return node.label;
        }
    }

    private static class Node {

        private int parent;

        private int label;

        private int count;

        private int rank;

        private Node(int label) {
            this.label = label;
            this.parent = label;
            this.count = 1;
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
