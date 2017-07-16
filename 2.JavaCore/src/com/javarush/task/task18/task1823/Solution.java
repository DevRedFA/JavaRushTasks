package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String file = reader.readLine();
                if (file.equals("exit")) break;
                new ReadThread(file).start();
            }
//            System.out.println(resultMap);
        }
    }

    public static class ReadThread extends Thread {
        int[] table = new int[256];

        public ReadThread(String fileName) throws IOException {
           findMax(fileName);
        }
        // implement file reading here - реализуйте чтение из файла тут


        private void findMax(String file) throws IOException {
            try (BufferedReader freader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                while (freader.ready()) {
                    table[freader.read()]++;
                }
            }
            int max = 0;
            int maxValue = 0;
            for (int i=0; i<table.length; i++) {
                if (table[i] > max) {
                    max = table[i];
                    maxValue = i;
                }
            }
            resultMap.put(file, maxValue);
        }
    }
}
