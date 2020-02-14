package com.leetcode.algorithm.graph.dfs;

import com.leetcode.algorithm.graph.Graph;
import com.leetcode.algorithm.graph.Node;

import java.util.List;

public class MotherNode {

    public static String getMotherNode(Graph graph) {
        Node lastNode = null;
        for (Node node : graph.getNodes().values()) {
            if (!node.isVisited()) {
                lastNode = node;
                DFS.dfs(graph, node.getLabel());
            }
        }

        if (lastNode == null) {
            return null;
        }
        cleanVisited(graph);
        List<String> dfsResult = DFS.dfs(graph, lastNode.getLabel());
        if (dfsResult.size() == graph.getNodes().size()) {
            return lastNode.getLabel();
        }
        return null;
    }

    private static void cleanVisited(Graph graph) {
        for (Node node : graph.getNodes().values()) {
            node.setVisited(false);
        }
    }
}
