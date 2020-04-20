package com.codeforces.div3.notfinished.round527;

import java.io.*;
import java.util.*;

public class ProblemD2 {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        List<Pair<Integer, Boolean>> pairs = new ArrayList<>();
        pairs.add(new Pair<>(list.get(0), true));
        for (int i = 1; i < n; i++) {
            if (list.get(i).equals(pairs.get(pairs.size() - 1).first)) {
                pairs.get(pairs.size() - 1).second = !pairs.get(pairs.size() - 1).second;
            } else {
                pairs.add(new Pair<>(list.get(i), true));
            }
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.value));
        Node last = null;
        for (int i = 0; i < pairs.size(); i++) {
            Node node = new Node(pairs.get(i).first, pairs.get(i).second);
            node.left = last;
            if (last != null) {
                last.right = node;
            }
            priorityQueue.add(node);
            last = node;
        }

        boolean cant = false;
        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            if (node.visited) {
                continue;
            }
            if (node.left == null && node.right == null) {
                break;
            }
            if (node.odd) {
                cant = true;
                break;
            }
            if (node.left == null) {
                node.right.left = null;
            } else if (node.right == null) {
                node.left.right = null;
            } else {
                int x = node.left.value;
                int y = node.right.value;
                if (x < y) {
                    node.left.right = node.right;
                } else if (y < x) {
                    node.right.left = node.left;
                } else {
                    Node mid = new Node(x, node.left.odd ^ node.right.odd);
                    mid.left = node.left.left;
                    if (node.left.left != null) {
                        node.left.left.right = mid;
                    }
                    mid.right = node.right.right;
                    if (node.right.right != null) {
                        node.right.right.left = mid;
                    }
                    node.left.visited = true;
                    node.right.visited = true;
                    priorityQueue.add(mid);
                }
            }
        }


        if (cant) {
            out.println("NO");
        } else {
            out.println("YES");
        }



        out.flush();
    }

    private static class Node {

        private int value;

        private boolean odd;

        private Node left;

        private Node right;

        boolean visited;

        private Node(int value, boolean odd) {
            this.value = value;
            this.odd = odd;
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
