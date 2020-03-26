package com.codeforces.div3.round624;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = scanner.nextInt();
        for (int p = 0; p < t; p++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            int min = Integer.MAX_VALUE;
            int ansA = 0, ansB = 0, ansC = 0;
            for (int i = 1; i <= 2 * a; i++) {
                for (int j = 1; j <= (2 * b) / i; j++) {
                    int x = (c / (i * j)) * i * j;
                    int y = (c / (i * j) + 1) * i * j;
                    int sum = Math.abs(i - a);
                    sum += Math.abs(i * j - b);
                    sum += Math.min((Math.abs(x - c)), (Math.abs(y - c)));
                    if (sum < min) {
                        min = sum;
                        ansA = i;
                        ansB = i * j;
                        if (Math.abs(x - c) < Math.abs(y - c)) {
                            ansC = x;
                        } else {
                            ansC = y;
                        }
                    }
                    min = Math.min(min, sum);
                }
            }

            out.println(min);
            out.println(ansA + " " + ansB + " " + ansC);
        }

        out.flush();
    }
}
