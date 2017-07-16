package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
//        words.add("file");
//        words.add("see");
//        words.add("A");
    }

    public static void main(String[] args) {
        String name = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(name))) {
            String s;
            int i = 0;
            while ((s = reader.readLine()) != null) {
                for (String w : words) {
                    if (s.contains(w)) i++;
                }
                if (i == 2) {
                    System.out.println(s);
                }
                i=0;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
