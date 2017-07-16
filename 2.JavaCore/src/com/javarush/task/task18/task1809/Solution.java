package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();

        FileInputStream file1 = new FileInputStream(name1);
        FileOutputStream file2 = new FileOutputStream(name2);


        if (file1.available() > 0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[file1.available()];
            int count = file1.read(buffer);
            for (int i = count - 1; i >= 0; i--) {
                file2.write(buffer[i]);
            }
        }
        file1.close();
        file2.close();

    }

}
