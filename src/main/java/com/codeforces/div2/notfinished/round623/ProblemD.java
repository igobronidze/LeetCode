package com.codeforces.div2.notfinished.round623;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();

        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair<>(scanner.nextInt(), 0));
        }
        for (int i = 0; i < n; i++) {
            list.get(i).second = scanner.nextInt();
        }

        list.sort(Comparator.comparingInt(t -> t.first));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((t1, t2) -> Integer.compare(t2, t1));
        priorityQueue.add(list.get(0).second);
        long sum = list.get(0).second;
        long ans = 0;
        int x = list.get(0).first;
        for (int i = 1; i < n; i++) {
            if (list.get(i).first == x) {
                priorityQueue.add(list.get(i).second);
                sum += list.get(i).second;
            } else {
                for (int j = 0; j < list.get(i).first - x; j++) {
                    if (priorityQueue.isEmpty()) {
                        break;
                    }
                    int k = priorityQueue.poll();
                    sum -= k;
                    ans += sum;
                }
                priorityQueue.add(list.get(i).second);
                sum += list.get(i).second;
                x = list.get(i).first;
            }
        }
        while (!priorityQueue.isEmpty()) {
            int k = priorityQueue.poll();
            sum -= k;
            ans += sum;
        }

        out.println(ans);

        out.flush();
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
