package com.leetcode.algorithm.graph.dfs;

import com.leetcode.algorithm.graph.Graph;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class DFSTest {

    @Test
    public void testBFS() {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        Assert.assertEquals(Arrays.asList("2", "0", "1", "3"), DFS.dfs(graph, 2));
    }
}
