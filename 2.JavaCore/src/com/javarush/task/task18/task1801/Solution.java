package com.javarush.task.task18.task1801;

import java.io.*;


/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader =new BufferedReader( new InputStreamReader(System.in));
        int max=0;

        try (FileInputStream freader = new FileInputStream((reader.readLine()))) {
            while (freader.available()>0) {
            int buf = freader.read();
                max= buf>max ? buf:max;
            }
            System.out.println(max);
        }
    }
}
