package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(args[0]))) {
            TreeSet<Character> set = new TreeSet<>();
            while (reader.ready()) {
                int i = reader.read();
                if (Character.isLetter((char) i)) set.add(Character.toLowerCase((char)i));
            }
            int n = set.size() < 5 ? set.size() : 5;
            Iterator<Character> it = set.iterator();
            for (int i = 0; i < n; i++) {
                System.out.print(it.next());
            }

        }
    }
}
