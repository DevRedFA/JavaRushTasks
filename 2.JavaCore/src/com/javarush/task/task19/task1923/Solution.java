package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        List<String> list = new LinkedList<>();
        try (BufferedReader reader1 = new BufferedReader(new FileReader(args[0]))) {
            while (reader1.ready()) {
                list.add(reader1.readLine());
            }
        }


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
            for (String st : list) {
                String[] sm = st.split(" ");
                for (int i = 0; i < sm.length; i++) {
                    if (sm[i].length() > 6) {
                        writer.write(sm[i]);
                        if (i < sm.length - 1) writer.write(",");
                    }
                }
            }
        }
    }
}
