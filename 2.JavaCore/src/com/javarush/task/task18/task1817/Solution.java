package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length < 1) {
            throw new IOException("отсутствует входной параметр с именем файла");
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        Pattern p = Pattern.compile("[^( )]");
        while (in.ready()){
            sb.append(in.readLine());
        }
        Matcher m = p.matcher(sb.toString());
        String s = m.replaceAll("");

        System.out.format("%.2f%n", (float) s.length() /sb.length()*100);
        in.close();
//        Thread.sleep(1000);
    }
}
