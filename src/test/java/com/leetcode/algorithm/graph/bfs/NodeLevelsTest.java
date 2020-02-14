package com.leetcode.algorithm.graph.bfs;

import com.leetcode.algorithm.graph.Graph;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class NodeLevelsTest {

    @Test
    public void testNodeLevels() {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(6, 7);

        Map<String, Integer> expectedLevels = new HashMap<>();
        expectedLevels.put("0", 0);
        expectedLevels.put("1", 1);
        expectedLevels.put("2", 1);
        expectedLevels.put("3", 2);
        expectedLevels.put("4", 2);
        expectedLevels.put("5", 2);
        expectedLevels.put("6", 2);
        expectedLevels.put("7", 3);

        Assert.assertEquals(expectedLevels, NodeLevel.getNodeLevels(graph, "0"));
    }
}
