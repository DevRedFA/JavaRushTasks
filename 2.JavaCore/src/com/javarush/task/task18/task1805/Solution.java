package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new LinkedList();
        int val = 0;

        try (FileInputStream freader = new FileInputStream((reader.readLine()))) {
            while (freader.available() > 0) {
                val = freader.read();
                if (!list.contains(val)) {
                list.add(val);}
            }
            Collections.sort(list);

            for (Integer i: list) {
                System.out.print(i + " ");
            }

        }
    }
}