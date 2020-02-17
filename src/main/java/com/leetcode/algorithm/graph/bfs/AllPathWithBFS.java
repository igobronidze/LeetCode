package com.leetcode.algorithm.graph.bfs;

import com.leetcode.algorithm.graph.Graph;
import com.leetcode.algorithm.graph.Node;

import java.util.*;

public class AllPathWithBFS {

    private static List<List<String>> resultPaths = new ArrayList<>();

    public static List<List<String>> getAllPath(Graph graph, String srcNodeLabel, String destNodeLabel) {
        bfs(graph.getNodes().get(srcNodeLabel), destNodeLabel);
        return resultPaths;
    }

    public static void bfs(Node srcNode, String destNodeLabel) {
        LinkedList<Pair<Node, List<String>>> linkedList = new LinkedList<>();
        linkedList.add(new Pair<>(srcNode, Collections.singletonList(srcNode.getLabel())));
        while(!linkedList.isEmpty()) {
            Pair<Node, List<String>> nodeAndPath = linkedList.poll();

            if (nodeAndPath.getFirst().getLabel().equals(destNodeLabel)) {
                resultPaths.add(nodeAndPath.getSecond());
            } else {
                nodeAndPath.getFirst().setVisited(true);
                for (Node adjacent : nodeAndPath.getFirst().getEdges().values()) {
                    if (!adjacent.isVisited()) {
                        List<String> path = new ArrayList<>(nodeAndPath.getSecond());
                        path.add(adjacent.getLabel());
                        linkedList.add(new Pair<>(adjacent, path));
                    }
                }
            }
        }
    }

    private static class Pair<U, V> {
        public final U first;   	// first field of a Pair
        public final V second;  	// second field of a Pair

        // Constructs a new Pair with specified values
        public Pair(U first, V second)
        {
            this.first = first;
            this.second = second;
        }

        public U getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }

        @Override
        // Checks specified object is "equal to" current object or not
        public boolean equals(Object o)
        {
            if (this == o)
                return true;

            if (o == null || getClass() != o.getClass())
                return false;

            Pair<?, ?> pair = (Pair<?, ?>) o;

            // call equals() method of the underlying objects
            if (!first.equals(pair.first))
                return false;
            return second.equals(pair.second);
        }

        @Override
        // Computes hash code for an object to support hash tables
        public int hashCode()
        {
            // use hash codes of the underlying objects
            return 31 * first.hashCode() + second.hashCode();
        }

        @Override
        public String toString()
        {
            return "(" + first + ", " + second + ")";
        }
    }
}
