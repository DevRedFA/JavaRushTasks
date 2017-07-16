package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (BufferedReader freader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())))) {
            while (true) {
                String data = freader.readLine();
                String[] tokens = data.split(" ");
                if (Integer.parseInt(tokens[0]) == (Integer.parseInt(args[0]))) {
                    System.out.println(data);
                    break;
                }
            }
        }
    }
}
