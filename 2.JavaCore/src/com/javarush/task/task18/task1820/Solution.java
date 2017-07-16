package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine(), f2 = reader.readLine();
        reader.close();
        Scanner sc = new Scanner(new BufferedReader(new FileReader(f1)));
        sc.useLocale(Locale.US);
        FileWriter file2 = new FileWriter((f2));
        while (sc.hasNext()) {
            if (sc.hasNextDouble()) {
                String q = Long.toString(Math.round(sc.nextDouble()));
                file2.write(q);
                file2.write(" ");
            } else sc.next();
        }
        sc.close();
        file2.close();
    }
}
