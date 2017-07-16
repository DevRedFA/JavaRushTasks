package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] table = new int[256];
        int[] tableSorted;

        int max=0;

        try (FileInputStream freader = new FileInputStream((reader.readLine()))) {
            while (freader.available() > 0) {


                table[freader.read()]++;
            }
            tableSorted = table.clone();
            Arrays.sort(tableSorted);
            for (int i : tableSorted) {
                if (i > 0) {
                    max = i;
                    break;
                }
            }
            for (int i = 0; i < table.length; i++) {
                if (table[i] == max) {
                    System.out.print(i + " ");
                }
            }

        }
    }
}

