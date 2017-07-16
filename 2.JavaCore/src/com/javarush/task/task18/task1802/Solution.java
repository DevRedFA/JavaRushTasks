package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {


    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MAX_VALUE;

        try (FileInputStream freader = new FileInputStream((reader.readLine()))) {
            while (freader.available() > 0) {
                int buf = freader.read();
                max = buf < max ? buf : max;
            }
            System.out.println(max);
        }
    }
}

