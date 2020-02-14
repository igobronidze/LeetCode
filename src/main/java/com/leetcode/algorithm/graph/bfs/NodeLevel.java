package com.leetcode.algorithm.graph.bfs;

import com.leetcode.algorithm.graph.Graph;
import com.leetcode.algorithm.graph.Node;

import java.util.HashMap;
import java.util.Map;

public class NodeLevel {

    public static Map<String, Integer> getNodeLevels(Graph graph, String rootLabel) {
        BFS.bfs(graph, rootLabel);
        Map<String, Integer> nodeLevels = new HashMap<>();
        for (Node node : graph.getNodes().values()) {
            nodeLevels.put(node.getLabel(), node.getLevel());
        }
        return nodeLevels;
    }
}
