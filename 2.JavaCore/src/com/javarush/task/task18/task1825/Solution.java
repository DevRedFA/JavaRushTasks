package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> list = new LinkedList<String>();
        Comparator<String> cmp = (obj1, obj2) -> {
            String[] st1 = obj1.split("part");
            String[] st2 = obj2.split("part");
            int s1 = Integer.parseInt(st1[st1.length - 1]);
            int s2 = Integer.parseInt(st2[st2.length - 1]);
            if (s1 == s2) {
                return 0;
            }
            if (s2 > s1) {
                return -1;
            }
            if (s1 > s2) {
                return 1;
            }
            return 0;
        };

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String name = null;
            while (true) {
                name = reader.readLine();
                if (name.equals("end")) break;
                list.add(name);
            }
        }
        Collections.sort(list, cmp);
        String newFile = list.get(0);
        newFile = newFile.substring(0, newFile.lastIndexOf("p") - 1);
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile)))) {
            while (!list.isEmpty()) {
                try (BufferedReader freader = new BufferedReader(new InputStreamReader(new FileInputStream(list.remove(0))))) {
                    while (freader.ready())
                        writer.write(freader.read());
                }
            }
        }
    }
}