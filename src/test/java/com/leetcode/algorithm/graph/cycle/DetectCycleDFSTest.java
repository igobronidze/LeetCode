package com.leetcode.algorithm.graph.cycle;

import com.leetcode.algorithm.graph.Graph;
import org.junit.Assert;
import org.junit.Test;

public class DetectCycleDFSTest {

    @Test
    public void testIsCycle() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        Assert.assertTrue(DetectCycleDFS.isCycle(graph));
    }
}
