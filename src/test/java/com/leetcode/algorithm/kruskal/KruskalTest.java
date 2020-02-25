package com.leetcode.algorithm.kruskal;

import com.leetcode.algorithm.graph.kruskal.Kruskal;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class KruskalTest {

    @Test
    public void testKruskal() {
        List<Kruskal.Edge> expected = Arrays.asList(new Kruskal.Edge(2, 3, 4),
                new Kruskal.Edge(0, 3, 5),
                new Kruskal.Edge(0, 1, 10));

        int[][] edges = new int[][] {
            {0, 1, 10},
            {0, 2, 6},
            {0, 3, 5},
            {1, 3, 15},
            {2, 3, 4}
        };

        List<Kruskal.Edge> result = Kruskal.kruskal(4, edges);

        Assert.assertEquals(expected, result);
    }
}
