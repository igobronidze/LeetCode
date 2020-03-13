package com.codeforces.round627;

import java.io.FileWriter;
import java.io.IOException;

public class HackHelper {

//    public static void main(String[] args) throws IOException {
//
//        FileWriter fileWriter = new FileWriter("C:\\Users\\Lenovo\\Desktop\\r.txt");
//
//        int n = 200000;
//        fileWriter.write(n + System.lineSeparator());
//        for (int i = 1; i < n; i++) {
//            fileWriter.write("2 ");
//        }
//        fileWriter.write("2" + System.lineSeparator());
//
//        for (int i = 1; i < n; i++) {
//            fileWriter.write("1 ");
//        }
//        fileWriter.write("1");
//
//        fileWriter.close();
//    }

    public static void main(String[] args) throws IOException {

        int n = 200000;
        System.out.println(n);
        for (int i = 1; i < n; i++) {
            System.out.print("2 ");
        }
        System.out.println(2);

        for (int i = 1; i < n; i++) {
            System.out.print("1 ");
        }
        System.out.println(1);
    }
}
