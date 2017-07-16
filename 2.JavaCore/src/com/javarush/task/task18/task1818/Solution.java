package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        byte[]fb2,fb3;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String f1=reader.readLine(),f2=reader.readLine(),f3=reader.readLine();
        reader.close();
        BufferedOutputStream file1=new BufferedOutputStream(new FileOutputStream(f1));
        BufferedInputStream file2=new BufferedInputStream(new FileInputStream(f2));
        BufferedInputStream file3=new BufferedInputStream(new FileInputStream(f3));

        while (file2.available()>0){
            fb2=new byte[file2.available()];
            file2.read(fb2);
            file1.write(fb2);
        }
        file2.close();
        while (file3.available()>0){
            fb3=new byte[file3.available()];
            file3.read(fb3);
            file1.write(fb3);
        }
        file3.close();
        file1.close();

    }
}
