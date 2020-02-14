package com.leetcode.algorithm.graph.dfs;

import com.leetcode.algorithm.graph.Graph;
import com.leetcode.algorithm.graph.Node;

import java.util.ArrayList;
import java.util.List;

public class AllPathWithDFS {

    private static List<List<String>> resultPaths = new ArrayList<>();

    public static List<List<String>> getAllPath(Graph graph, String srcNodeLabel, String destNodeLabel) {
        dfs(graph.getNodes().get(srcNodeLabel), new ArrayList<>(), destNodeLabel);
        return resultPaths;
    }

    public static void dfs(Node node, List<String> visited, String destNodeLabel) {
        node.setVisited(true);
        visited.add(node.getLabel());
        if (node.getLabel().equals(destNodeLabel)) {
            resultPaths.add(visited);
            node.setVisited(false);
            return;
        }
        for (Node adjacent : node.getEdges().values()) {
            if (!adjacent.isVisited()) {
                dfs(adjacent, new ArrayList<>(visited), destNodeLabel);
            }
        }
        node.setVisited(false);
    }
}
