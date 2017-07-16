package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] table = new int[256];
        try (FileInputStream freader = new FileInputStream((reader.readLine()))) {
            while (freader.available() > 0) {
                table[freader.read()]++;
            }
            System.out.print(table[44]);
        }
    }
}

