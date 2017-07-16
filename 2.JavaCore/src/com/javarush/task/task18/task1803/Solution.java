package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;


/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] table = new int[256];
        int[] tableSorted;
        int max;
        try (FileInputStream freader = new FileInputStream((reader.readLine()))) {
            while (freader.available() > 0) {
                table[freader.read()]++;
            }
            tableSorted = table.clone();
            Arrays.sort(tableSorted);
            max = tableSorted[tableSorted.length-1];
            for (int i = 0; i < table.length; i++) {
                if (table[i] == max) {
                    System.out.print(i + " ");
                }
            }

        }
    }
}
