package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 =reader.readLine();
        String name2 =reader.readLine();
        String name3 =reader.readLine();
        FileInputStream file1 = new FileInputStream(name1);
        FileOutputStream file2 = new FileOutputStream(name2);
        FileOutputStream file3 = new FileOutputStream(name3);

//        FileInputStream file1 = new FileInputStream(reader.readLine());
//        FileOutputStream file2 = new FileOutputStream(reader.readLine());
//        FileOutputStream file3 = new FileOutputStream(reader.readLine());

        if (file1.available() > 0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[file1.available()];
            int count = file1.read(buffer);
            if (count % 2 == 0) {

                file2.write(buffer, 0, count / 2);
                file3.write(buffer, count / 2 , count/2);
            } else {

                file2.write(buffer, 0, count / 2 + 1);
                file3.write(buffer, count / 2 + 1, count/2);
            }
        }


        file1.close();
        file2.close();
        file3.close();
    }
}
