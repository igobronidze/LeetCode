package com.leetcode.algorithm.graph.bfs;

import com.leetcode.algorithm.graph.Graph;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BFSTest {

    @Test
    public void testBFS() {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        Assert.assertEquals(Arrays.asList("2", "0", "3", "1"), BFS.bfs(graph, 2));
    }
}
