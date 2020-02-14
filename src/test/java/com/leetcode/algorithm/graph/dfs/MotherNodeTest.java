package com.leetcode.algorithm.graph.dfs;

import com.leetcode.algorithm.graph.Graph;
import org.junit.Assert;
import org.junit.Test;

public class MotherNodeTest {

    @Test
    public void testMotherNode() {
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(4, 1);
        graph.addEdge(6, 4);
        graph.addEdge(5, 6);
        graph.addEdge(5, 2);
        graph.addEdge(6, 0);

        Assert.assertEquals("5", MotherNode.getMotherNode(graph));
    }
}
