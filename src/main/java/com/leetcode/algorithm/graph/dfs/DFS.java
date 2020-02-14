package com.leetcode.algorithm.graph.dfs;

import com.leetcode.algorithm.graph.Graph;
import com.leetcode.algorithm.graph.Node;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    public static List<String> dfs(Graph graph, int startLabel) {
        return dfs(graph, String.valueOf(startLabel));
    }

    public static List<String> dfs(Graph graph, String startLabel) {
        List<String> visited = new ArrayList<>();
        if (!graph.getNodes().containsKey(startLabel)) {
            return visited;
        }

        return innerDFS(graph.getNodes().get(startLabel), visited);
    }

    public static List<String> innerDFS(Node node, List<String> visited) {
        node.setVisited(true);
        visited.add(node.getLabel());
        for (Node adjacent : node.getEdges().values()) {
            if (!adjacent.isVisited()) {
                innerDFS(adjacent, visited);
            }
        }
        return visited;
    }
}
