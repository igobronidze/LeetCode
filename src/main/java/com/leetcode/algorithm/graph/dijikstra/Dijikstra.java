package com.leetcode.algorithm.graph.dijikstra;

import java.util.Objects;
import java.util.PriorityQueue;

public class Dijikstra {

    public static int[] dijikstra(int[][] graph) {
        int[] ans = new int[graph.length];
        for (int i = 1; i < graph.length; i++) {
            ans[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Pair(0, 0));
        while (!priorityQueue.isEmpty()){
            Pair pair = priorityQueue.poll();
            for (int i = 0; i < graph.length; i++) {
                if (graph[pair.first][i] != 0) {
                    if (ans[i] > ans[pair.first] + graph[pair.first][i]) {
                        ans[i] = ans[pair.first] + graph[pair.first][i];
                        priorityQueue.remove(new Pair(i, 0));
                        priorityQueue.add(new Pair(i, ans[i]));
                    }
                }
            }
        }

        return ans;
    }

    private static class Pair implements Comparable<Pair> {

        private int first;

        private int second;

        public Pair() {
        }

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair pair) {
            return Integer.compare(this.second, pair.second);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first);
        }
    }
}
