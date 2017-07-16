package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.Scanner;
import java.util.regex.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        String in, out;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            in = reader.readLine();
            out = reader.readLine();
        }
        Pattern p = Pattern.compile("[\\D+]");

        try (BufferedReader reader = new BufferedReader(new FileReader(in))) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(out))) {
                while (reader.ready()) {
                    String[] s = reader.readLine().split(" ");
                    for (String st : s) {
                        Matcher m = p.matcher(st);
                        if (!m.find()) {
                            writer.write(st + " ");
                        }
                    }
                }
            }
        }
    }
}
