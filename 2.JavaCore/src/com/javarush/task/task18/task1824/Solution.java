package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String file = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                file = reader.readLine();
                try (BufferedReader freader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                } catch (FileNotFoundException e) {
                    System.out.print(file);
                    break;
                }
            }
        } catch (IOException e) {
        }
    }
}
