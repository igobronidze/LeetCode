package com.leetcode.algorithm.graph.bfs;

import com.leetcode.algorithm.graph.Graph;
import com.leetcode.algorithm.graph.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BFS {

    public static List<String> bfs(Graph graph, int startLabel) {
        return BFS.bfs(graph, String.valueOf(startLabel));
    }

    public static List<String> bfs(Graph graph, String startLabel) {
        LinkedList<Node> toVisit = new LinkedList<>();
        List<String> visited = new ArrayList<>();

        Node startNode = graph.getNodes().get(startLabel);
        if (startNode == null) {
            return visited;
        }

        startNode.setVisited(true);
        toVisit.add(startNode);
        while (!toVisit.isEmpty()) {
            Node node = toVisit.poll();
            visited.add(node.getLabel());
            for (Node adjacent : node.getEdges().values()) {
                if (!adjacent.isVisited()) {
                    toVisit.add(adjacent);
                    adjacent.setVisited(true);
                    adjacent.setLevel(node.getLevel() + 1);
                }
            }
        }

        return visited;
    }
}
