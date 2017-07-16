package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static List<String> s1 = new LinkedList<>();
    public static List<String> s2 = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        String file1, file2;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = reader.readLine();
            file2 = reader.readLine();
        }

        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1))) {
            while (reader1.ready()) {
                s1.add(reader1.readLine());
            }
        }
        try (BufferedReader reader2 = new BufferedReader(new FileReader(file2))) {
            while (reader2.ready()) {
                s2.add(reader2.readLine());
            }
        }
        for (int i = 0; i < s1.size(); i++) {
            if (s2.size() > 0) {
                if (s1.get(i).equals(s2.get(0))) {
                    lines.add(new LineItem(Type.SAME, s1.get(i)));
                    s2.remove(0);
                } else {
                    if (s2.size() > 1) {
                        if (s1.get(i).equals(s2.get(1))) {
                            lines.add(new LineItem(Type.ADDED, s2.get(0)));
                            s2.remove(0);
                            i--;
                        } else {
                            lines.add(new LineItem(Type.REMOVED, s1.get(i)));
                        }
                    }
                }
            } else {
                lines.add(new LineItem(Type.REMOVED, s1.get(i)));
            }
        }
        if (s2.size() > 0) {
            for (String s : s2) {
                lines.add(new LineItem(Type.ADDED, s));
            }
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
