package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String[] st;
        Map<String, Double> map = new HashMap<String, Double>();
        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader1 = new BufferedReader(new FileReader(args[0]))) {
            while (reader1.ready()) {
                sb.append(reader1.readLine());
                st = sb.toString().split(" ");
                if (map.containsKey(st[0])) {
                    map.put(st[0], map.get(st[0]) + Double.parseDouble(st[1]));
                } else map.put(st[0], Double.parseDouble(st[1]));
                sb.delete(0, sb.length());
            }
        }
        double max = 0;

        for (String s : map.keySet()) {
            max = map.get(s) > max ? map.get(s) : max;
        }

        List<Map.Entry<String, Double>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, Comparator.comparing(q -> (q.getKey())));

        Map<String, Double> result = new LinkedHashMap<>();
        for (Map.Entry<String, Double> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        for (String s : result.keySet()) {
            if (map.get(s) == max) {
                System.out.println(s);
            }
        }
    }
}
