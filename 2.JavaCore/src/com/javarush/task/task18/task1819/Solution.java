package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

    public class Solution {
        public static void main(String[] args) throws IOException {
            byte[] fb1 = null, fb2 = null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String f1 = reader.readLine(), f2 = reader.readLine();
            reader.close();
            BufferedInputStream file1in = new BufferedInputStream(new FileInputStream(f1));
            BufferedInputStream file2 = new BufferedInputStream(new FileInputStream(f2));
            if (file2.available() > 0) {
                fb2 = new byte[file2.available()];
                file2.read(fb2);
            }
            if (file1in.available() > 0) {
                fb1 = new byte[file1in.available()];
                file1in.read(fb1);
            }

            file2.close();
            file1in.close();

            BufferedOutputStream file1out = new BufferedOutputStream(new FileOutputStream(f1));
            file1out.write(fb2);
            file1out.write(fb1);
            file1out.close();

        }
    }
