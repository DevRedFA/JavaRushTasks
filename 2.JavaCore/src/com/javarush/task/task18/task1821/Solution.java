package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] table = new int[256];
        try (BufferedReader freader =new BufferedReader(new InputStreamReader(new FileInputStream(args[0])))) {
            while (freader.ready()) {
                table[freader.read()]++;
            }
        }
        for (int i=0; i<table.length; i++){
            if (table[i]!=0)
            System.out.println((char)i + " " + table[i]);
        }
    }
}