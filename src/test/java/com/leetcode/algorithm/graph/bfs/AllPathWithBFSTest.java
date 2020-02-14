package com.leetcode.algorithm.graph.bfs;

import com.leetcode.algorithm.graph.Graph;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AllPathWithBFSTest {

    @Test
    public void testAllPathWithDFS() {
        Graph graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(2,0);
        graph.addEdge(2,1);
        graph.addEdge(1,3);

        List<List<String>> expectedResult = Arrays.asList(
                Arrays.asList("2", "0", "3"),
                Arrays.asList("2", "1", "3"),
                Arrays.asList("2", "0", "1", "3")
        );

        Assert.assertEquals(expectedResult, AllPathWithBFS.getAllPath(graph, "2", "3"));
    }
}
