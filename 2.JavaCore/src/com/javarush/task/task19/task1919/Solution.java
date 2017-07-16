package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.util.*;
import java.util.function.Function;


public class Solution {
    public static void main(String[] args) throws Exception {
        String file1;
        String[] st;
        Map<String, Double> map = new HashMap<String, Double>();
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = reader.readLine();
        }
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1))) {
            while (reader1.ready()) {
                sb.append(reader1.readLine());
                st = sb.toString().split(" ");
                if (map.containsKey(st[0])) {
                    map.put(st[0], map.get(st[0]) + Double.parseDouble(st[1]));
                } else map.put(st[0], Double.parseDouble(st[1]));
                sb.delete(0, sb.length());
            }
        }

        List<Map.Entry<String, Double>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, Comparator.comparing(q -> (q.getValue())));

        Map<String, Double> result = new LinkedHashMap<>();
        for (Map.Entry<String, Double> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        for (String s : result.keySet()) {
            System.out.println(s + " " + map.get(s));
        }

    }


}