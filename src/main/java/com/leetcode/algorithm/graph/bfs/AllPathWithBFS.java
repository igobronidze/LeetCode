package com.leetcode.algorithm.graph.bfs;

import com.leetcode.algorithm.graph.Graph;
import com.leetcode.algorithm.graph.Node;
import javafx.util.Pair;

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

            if (nodeAndPath.getKey().getLabel().equals(destNodeLabel)) {
                resultPaths.add(nodeAndPath.getValue());
            } else {
                nodeAndPath.getKey().setVisited(true);
                for (Node adjacent : nodeAndPath.getKey().getEdges().values()) {
                    if (!adjacent.isVisited()) {
                        List<String> path = new ArrayList<>(nodeAndPath.getValue());
                        path.add(adjacent.getLabel());
                        linkedList.add(new Pair<>(adjacent, path));
                    }
                }
            }
        }
    }
}
