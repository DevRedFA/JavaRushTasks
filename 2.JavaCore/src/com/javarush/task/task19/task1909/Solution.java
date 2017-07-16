package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.regex.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        String in, out;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            in = reader.readLine();
            out = reader.readLine();
        }
        Pattern p = Pattern.compile("[\\.]+");

        try (BufferedReader reader = new BufferedReader(new FileReader(in))) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(out))) {
                while (reader.ready()) {
                    String st = reader.readLine();
                    Matcher m = p.matcher(st);
                    writer.write(m.replaceAll("!"));
                }
            }
        }
    }
}


