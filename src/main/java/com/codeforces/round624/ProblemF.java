package com.codeforces.round624;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemF {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        List<ProblemF.Pair<Long, Long>> xvList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            xvList.add(new ProblemF.Pair<>(scanner.nextLong(), 0L));
        }
        for (int i = 0; i < n; i++) {
            xvList.get(i).second = scanner.nextLong();
        }

        

        out.flush();
    }

    private class BinaryIndexedTree {

        private long[] bit;

        private int n;

        private BinaryIndexedTree(int n) {
            this.bit = new long[n + 1];
            this.n = n;
        }

        private void update(int index, int delta) {
            index++;
            while (index <= n) {
                bit[index] += delta;
                index += (index & (-index));
            }
        }

        private long getSum(int index) {
            index++;
            long sum = 0;
            while (index > 0) {
                sum += bit[index];
                index = index - (index & (-index));
            }
            return sum;
        }
    }

    private static class Pair<F, S> {

        private F first;

        private S second;

        public Pair() {}

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }

}
