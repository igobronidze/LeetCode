package com.leetcode.problems.p130;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    private int height;

    private int length;

    private Character[][] ans;

    private boolean[][] visited;

    private char[][] board;

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        this.height = board.length;
        this.length = board[0].length;
        this.ans = new Character[height][length];
        this.visited = new boolean[height][length];
        this.board = board;

        for (int i = 0; i < height; i++) {
            if (!visited[i][0] && board[i][0] == 'O') {
                bfs(i, 0);
            }
        }
        for (int i = 0; i < height; i++) {
            if (!visited[i][length - 1] && board[i][length - 1] == 'O') {
                bfs(i, length - 1);
            }
        }
        for (int i = 0; i < length; i++) {
            if (!visited[0][i] && board[0][i] == 'O') {
                bfs(0, i);
            }
        }
        for (int i = 0; i < length; i++) {
            if (!visited[height - 1][i] && board[height - 1][i] == 'O') {
                bfs(height - 1, i);
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if (ans[i][j] != null) {
                    board[i][j] = ans[i][j];
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(int i, int j) {
        LinkedList<Pair<Integer, Integer>> toVisit = new LinkedList<>();
        toVisit.add(new Pair<>(i, j));
        visited[i][j] = true;
        while (!toVisit.isEmpty()) {
            Pair<Integer, Integer> node = toVisit.poll();
            ans[node.first][node.second] = 'O';
            for (Pair<Integer, Integer> adjacent : getAdjacents(node.first, node.second)) {
                if (board[adjacent.first][adjacent.second] == 'O' && !visited[adjacent.first][adjacent.second]) {
                    visited[adjacent.first][adjacent.second] = true;
                    toVisit.add(adjacent);
                }
            }
        }
    }

    private List<Pair<Integer, Integer>> getAdjacents(int i, int j) {
        List<Pair<Integer, Integer>> adjacents = new ArrayList<>();
        if (i > 0) {
            adjacents.add(new Pair<>(i - 1, j));
        }
        if (j > 0) {
            adjacents.add(new Pair<>(i, j - 1));
        }
        if (i < height - 1) {
            adjacents.add(new Pair<>(i + 1, j));
        }
        if (j < length - 1) {
            adjacents.add(new Pair<>(i, j + 1));
        }
        return adjacents;
    }

    private class Pair<F, S> {

        private F first;

        private S second;

        public Pair() {}

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}