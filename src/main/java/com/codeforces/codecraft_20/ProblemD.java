package com.codeforces.codecraft_20;

import java.io.*;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int[][] matrix = new int[n + 1][n + 1];
        boolean[][] visited = new boolean[n + 1][n + 1];
        Pair<Integer, Integer>[][] pairs = new Pair[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                pairs[i][j] = new Pair<>(x, y);
            }
        }

        boolean cant = false;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited[i][j]) {
                    int x = pairs[i][j].first;
                    int y = pairs[i][j].second;
                    if (x != -1) {
                        Pair<Integer, Integer> root = new Pair<>(x, y);
                        if (!pairs[x][y].equals(root)) {
                            cant = true;
                            break;
                        }
                        if (visited[x][y]) {
                            cant = true;
                            break;
                        }
                        LinkedList<Pair<Integer, Integer>> toVisit = new LinkedList<>();
                        toVisit.add(root);
                        visited[x][y] = true;
                        matrix[x][y] = -1;
                        while (!toVisit.isEmpty()) {
                            Pair<Integer, Integer> node = toVisit.poll();
                            if (node.first != 1 && pairs[node.first - 1][node.second].equals(root) && !visited[node.first - 1][node.second]) {
                                matrix[node.first - 1][node.second] = 2;
                                toVisit.add(new Pair<>(node.first - 1, node.second));
                                visited[node.first - 1][node.second] = true;
                            }
                            if (node.first != n && pairs[node.first + 1][node.second].equals(root) && !visited[node.first + 1][node.second]) {
                                matrix[node.first + 1][node.second] = 1;
                                toVisit.add(new Pair<>(node.first + 1, node.second));
                                visited[node.first + 1][node.second] = true;
                            }
                            if (node.second != 1 && pairs[node.first][node.second - 1].equals(root) && !visited[node.first][node.second - 1]) {
                                matrix[node.first][node.second - 1] = 4;
                                toVisit.add(new Pair<>(node.first, node.second - 1));
                                visited[node.first][node.second - 1] = true;
                            }
                            if (node.second != n && pairs[node.first][node.second + 1].equals(root) && !visited[node.first][node.second + 1]) {
                                matrix[node.first][node.second + 1] = 3;
                                toVisit.add(new Pair<>(node.first, node.second + 1));
                                visited[node.first][node.second + 1] = true;
                            }
                        }
                    }
                }
            }
            if (cant) {
                break;
            }
        }

        Pair<Integer, Integer> minusPair = new Pair<>(-1, -1);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (pairs[i][j].first == -1) {
                    if (i != 1 && minusPair.equals(pairs[i - 1][j])) {
                        matrix[i][j] = 1;
                        continue;
                    }
                    if (i != n && minusPair.equals(pairs[i + 1][j])) {
                        matrix[i][j] = 2;
                        continue;
                    }
                    if (j != 1 && minusPair.equals(pairs[i][j - 1])) {
                        matrix[i][j] = 3;
                        continue;
                    }
                    if (j != n && minusPair.equals(pairs[i][j + 1])) {
                        matrix[i][j] = 4;
                        continue;
                    }
                    cant = true;
                    break;
                }
            }
            if (cant) {
                break;
            }
        }

        if (cant) {
            out.println("INVALID");
        } else {
            out.println("VALID");
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (matrix[i][j] == -1) {
                        out.print("X");
                    }
                    if (matrix[i][j] == 1) {
                        out.print("U");
                    }
                    if (matrix[i][j] == 2) {
                        out.print("D");
                    }
                    if (matrix[i][j] == 3) {
                        out.print("L");
                    }
                    if (matrix[i][j] == 4) {
                        out.print("R");
                    }
                }
                out.println();
            }
        }

        out.flush();
    }

    private static class Pair<F, S> {

        private F first;

        private S second;

        public Pair() {}

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) &&
                    Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
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

        private String nextLine(){
            String str = "";
            try {
                str = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
