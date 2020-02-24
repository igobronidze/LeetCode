package com.codeforces.round601;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemD {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = Integer.parseInt(scanner.nextLine());

        for (int p = 0; p < t; p++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            int l = Integer.parseInt(parts[0]);
            int r = Integer.parseInt(parts[1]);
            int k = Integer.parseInt(parts[2]);

            int [][] matrix = new int[101][101];
            int sumOfRice = 0;
            for (int i = 0; i < l; i++) {
                line = scanner.nextLine();
                for (int j = 0; j < r; j++) {
                    if (line.charAt(j) == 'R') {
                        matrix[i][j] = 1;
                        sumOfRice++;
                    }
                }
            }

            List<Pair<Character, Integer>> characters = getCharacters(k, sumOfRice);
            int index = 0;

            char [][] ans = new char[101][101];

            for (int i = 0; i < l; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < r; j++) {
                        ans[i][j] = characters.get(index).first;
                        if (matrix[i][j] == 1) {
                            characters.get(index).second--;
                        }
                        if (characters.get(index).second == 0 && index < k - 1) {
                            index++;
                        }
                    }
                } else {
                    for (int j = r - 1; j >= 0; j--) {
                        ans[i][j] = characters.get(index).first;
                        if (matrix[i][j] == 1) {
                            characters.get(index).second--;
                        }
                        if (characters.get(index).second == 0 && index < k - 1) {
                            index++;
                        }
                    }
                }
            }

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    out.print(ans[i][j]);
                }
                out.println();
            }

        }


        out.flush();
    }

    private static List<Pair<Character, Integer>> getCharacters(int k, int sumOfRice) {
        char c = '0';

        List<Pair<Character, Integer>> list = new ArrayList<>();

        for (int i = 0; i < sumOfRice % k; i++) {
            list.add(new Pair<>(c, sumOfRice / k + 1));
            if (c == '9') {
                c = 'a';
            } else if (c == 'z') {
                c = 'A';
            } else {
                c++;
            }
        }
        for (int i = list.size(); i < k; i++) {
            list.add(new Pair<>(c, sumOfRice / k));
            if (c == '9') {
                c = 'a';
            } else if (c == 'z') {
                c = 'A';
            } else {
                c++;
            }
        }
        return list;
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
