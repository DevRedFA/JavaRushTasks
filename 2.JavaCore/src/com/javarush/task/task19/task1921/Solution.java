package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        String[] st;
        Map<String, Double> map = new HashMap<String, Double>();
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("\\d+");
        try (BufferedReader reader1 = new BufferedReader(new FileReader(args[0]))) {
            while (reader1.ready()) {
                sb.append(reader1.readLine());
                Matcher m = p.matcher(sb);
                m.find();
                String name = sb.substring(0,m.start()-1);
                st = sb.substring(m.start()).split(" ");
                PEOPLE.add(new Person(name, new Date(Integer.parseInt(st[2])-1900,Integer.parseInt(st[1])-1,Integer.parseInt(st[0]))));
                sb.delete(0, sb.length());
            }
        }

    }
}
