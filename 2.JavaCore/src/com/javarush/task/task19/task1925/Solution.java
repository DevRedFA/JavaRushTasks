package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        List<String> list = new LinkedList<>();
//        String st;
        try (BufferedReader reader1 = new BufferedReader(new FileReader(args[0]))) {
            while (reader1.ready()) {
                list.add(reader1.readLine());
            }
//            st = reader1.readLine();
        }

        StringBuilder sb = new StringBuilder();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
            for (String st : list) {
                String[] sm = st.split(" ");
                for (int i = 0; i < sm.length; i++) {
                    if (sm[i].length() > 6) {
                        sb.append(sm[i]).append(",");
                    }
                }
            }
            writer.write(sb.substring(0, sb.length() - 1));
        }
    }
}
