package com.leetcode.problems.p208;

import java.util.HashMap;
import java.util.Map;

class Trie {

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.nodes == null) {
                node.nodes = new HashMap<>();
            }
            if (node.nodes.get(c) == null) {
                node.nodes.put(c, new Node());
            }
            node = node.nodes.get(c);
        }
        node.end = true;
    }

    public boolean search(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node == null || node.nodes == null) {
                return false;
            }
            if (node.nodes.get(c) == null) {
                return false;
            }
            node = node.nodes.get(c);
        }
        if (node == null) {
            return false;
        }
        return node.end;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            if (node == null || node.nodes == null) {
                return false;
            }
            if (node.nodes.get(c) == null) {
                return false;
            }
            node = node.nodes.get(c);
        }
        return true;
    }

    public class Node {

        private Map<Character, Node> nodes;

        private boolean end;
    }
}
