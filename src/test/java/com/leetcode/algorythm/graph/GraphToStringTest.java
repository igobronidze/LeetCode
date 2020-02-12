package com.leetcode.algorythm.graph;

import org.junit.Assert;
import org.junit.Test;

public class GraphToStringTest {

    @Test
    public void testToString() {
        Graph graph = new Graph(false);
        for (int i = 1; i <= 5; i++) {
            graph.addNode(String.valueOf(i));
        }
        graph.addEdge("1" , "5");
        graph.addEdge("1" , "3");
        graph.addEdge("3" , "5");
        graph.addEdge("5" , "2");
        graph.addEdge("4" , "1");
        graph.addEdge("3" , "2");
        graph.addEdge("2" , "4");
        graph.addEdge("4" , "3");

        System.out.println(graph);

        Assert.assertEquals("1 -> [3, 5]" + System.lineSeparator() +
                "2 -> [4]" + System.lineSeparator() +
                "3 -> [2, 5]" + System.lineSeparator() +
                "4 -> [1, 3]" + System.lineSeparator() +
                "5 -> [2]" + System.lineSeparator(), graph.toString());
    }
}
