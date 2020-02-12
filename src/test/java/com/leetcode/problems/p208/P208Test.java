package com.leetcode.problems.p208;

import org.junit.Assert;
import org.junit.Test;

public class P208Test {

    @Test
    public void testCase1() {
        Trie trie = new Trie();
        trie.insert("apple");
        Assert.assertTrue(trie.search("apple"));
        Assert.assertFalse(trie.search("app"));
        Assert.assertTrue(trie.startsWith("app"));
        trie.insert("app");
        Assert.assertTrue(trie.search("app"));
    }
}
