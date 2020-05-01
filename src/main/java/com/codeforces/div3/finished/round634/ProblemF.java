package com.codeforces.div3.finished.round634;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] colors = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = scanner.next();
                for (int j = 0; j < m; j++) {
                    colors[i][j] = s.charAt(j);
                }
            }
            char[][] directions = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = scanner.next();
                for (int j = 0; j < m; j++) {
                    directions[i][j] = s.charAt(j);
                }
            }

            Graph graph = new Graph(n, m, colors, directions);
            graph.dfs();
            Pair<Integer, Integer> ans = graph.solve();
            out.println(ans.first + " " + ans.second);
        }


        out.flush();
    }

    private static class Graph {

        private Node[][] nodes;

        private Graph(int n, int m, char[][] colors, char[][] directions) {
            nodes = new Node[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    nodes[i][j] = new Node(i, j, colors[i][j] == '0');
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    Node node = nodes[i][j];
                    switch (directions[i][j]) {
                        case 'L' :
                            node.adjacent = nodes[i][j - 1];
                            break;
                        case 'R' :
                            node.adjacent = nodes[i][j + 1];
                            break;
                        case 'U' :
                            node.adjacent = nodes[i - 1][j];
                            break;
                        case 'D' :
                            node.adjacent = nodes[i + 1][j];
                            break;
                    }
                }
            }
        }

        private void dfs() {
            int cycleIndex = 0;
            for (int i = 0; i < nodes.length; i++) {
                for (int j = 0; j < nodes[0].length; j++) {
                    if (nodes[i][j].color == 0) {
                        nodes[i][j].dfs(cycleIndex++);
                    }
                }
            }
        }

        private Pair<Integer, Integer> solve() {
            Map<Integer, Map<Integer, Boolean>> mapMap = new HashMap<>();
            for (int i = 0; i < nodes.length; i++) {
                for (int j = 0; j < nodes[0].length; j++) {
                    Node node = nodes[i][j];
                    if (!mapMap.containsKey(node.cycleIndex)) {
                        mapMap.put(node.cycleIndex, new HashMap<>());
                    }
                    if (!mapMap.get(node.cycleIndex).containsKey(node.pathIndex)) {
                        mapMap.get(node.cycleIndex).put(node.pathIndex, false);
                    }
                    if (node.black) {
                        mapMap.get(node.cycleIndex).put(node.pathIndex, true);
                    }
                }
            }
            Pair<Integer, Integer> ans = new Pair<>(0, 0);
            for (Map<Integer, Boolean> map : mapMap.values()) {
                ans.first += map.size();
                for (Boolean b : map.values()) {
                    if (b) {
                        ans.second++;
                    }
                }
            }
            return ans;
        }
    }

    private static class Node {

        private Pair<Integer, Integer> coordinate;

        private boolean black;

        private Node adjacent;

        private int color;

        private int pathIndex;

        private int cycleAmount;

        private int cycleIndex;

        private Node(int x, int y, boolean black) {
            this.coordinate = new Pair<>(x, y);
            this.black = black;
            this.pathIndex = -1;
        }

        private void dfs(int cycleIndex) {
            color = 1;
            if (adjacent.color == 0) {
                adjacent.dfs(cycleIndex);
            } else if (adjacent.color == 1) {
                Node node = adjacent;
                int x = 0;
                do {
                    node.pathIndex = x++;
                    node.cycleIndex = cycleIndex;
                    node = node.adjacent;
                } while (node != adjacent);
                node.cycleAmount = x;
            }
            if (cycleAmount == 0) {
                pathIndex = (adjacent.pathIndex + 1) % adjacent.cycleAmount;
                cycleAmount = adjacent.cycleAmount;
            }
            this.cycleIndex = adjacent.cycleIndex;
            color = 2;
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
