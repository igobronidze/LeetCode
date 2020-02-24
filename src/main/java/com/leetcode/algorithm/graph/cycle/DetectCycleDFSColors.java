package com.leetcode.algorithm.graph.cycle;

import com.leetcode.algorithm.graph.Graph;
import com.leetcode.algorithm.graph.Node;

public class DetectCycleDFSColors {

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
        if (node.getColor() == 1) {
            return true;
        }
        if (node.getColor() == 2) {
            return false;
        }

        node.setColor(1);
        for (Node adjacent : node.getEdges().values()) {
            if (isCycleForNode(adjacent)) {
                return true;
            }
        }
        node.setColor(2);
        return false;
    }
}
