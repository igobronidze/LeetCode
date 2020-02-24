package com.leetcode.algorithm.graph.cycle;

import com.leetcode.algorithm.graph.Graph;
import com.leetcode.algorithm.graph.Node;

public class DetectCycleDFS {

    public static boolean isCycle(Graph graph) {
        for (Node node : graph.getNodes().values()) {
            if (!node.isVisited()) {
                if (isCycleForNode(node)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isCycleForNode(Node node) {
        if (node.isCurrStack()) {
            return true;
        }
        if (node.isVisited()) {
            return false;
        }

        node.setVisited(true);
        node.setCurrStack(true);

        for (Node adjacent : node.getEdges().values()) {
            if (isCycleForNode(adjacent)) {
                return true;
            }
        }
        node.setCurrStack(false);
        return false;
    }
}
