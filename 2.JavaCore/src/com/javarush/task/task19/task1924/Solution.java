package com.javarush.task.task19.task1924;


import java.io.*;
import java.util.*;
import java.util.regex.Matcher;


/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws Exception {
        String file1;
        List<String> list = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = reader.readLine();
        }

        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1))) {
            while (reader1.ready()) {
                list.add(reader1.readLine());
            }
        }

        for (String st : list) {
            for (String s : st.split(" ")) {
                try {
                    if (Integer.parseInt(s) > 12) throw new NumberFormatException("больше)");
                    System.out.print( map.get(Integer.parseInt(s)) + " ");
                } catch (NumberFormatException e) {
                    System.out.print(s+ " ");
                }
            }
            System.out.print(System.lineSeparator());
        }
    }
}
