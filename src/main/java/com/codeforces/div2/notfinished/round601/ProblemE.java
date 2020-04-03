package com.codeforces.div2.notfinished.round601;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemE {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        int[] arr = new int[n + 1];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }

        if (sum == 1) {
            out.println(-1);
        } else {
            long min = Long.MAX_VALUE;
            for (int k = 2; k <=n ; k++) {
                if (sum % k == 0) {
                    long locAns = 0;
                    int index = 0;
                    while (index < n) {
                        List<Integer> list = new ArrayList<>();
                        while (list.size() != k && index < n) {
                            if (arr[index] == 1) {
                                list.add(index);
                            }
                            index++;
                        }

                        if (!list.isEmpty()) {
                            int mid = list.get(k / 2);
                            for (int i = 0; i < k; i++) {
                                locAns += Math.abs(mid - list.get(i));
                            }
                        }
                    }
                    min = Math.min(min, locAns);
                }
            }
            out.println(min);
        }




        out.flush();
    }
}
