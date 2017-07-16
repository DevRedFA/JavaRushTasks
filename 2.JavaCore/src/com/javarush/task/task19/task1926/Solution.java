package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        List<String> list = new LinkedList<>();
        String file1;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = reader.readLine();
        }
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1))) {
            while (reader1.ready()) {
                list.add(reader1.readLine());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
        System.out.println(sb.append(s).reverse().toString());
        sb.delete(0,sb.length());
        }
    }
}
