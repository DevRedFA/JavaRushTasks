package com.javarush.task.task32.task3202;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter sw = new StringWriter();
        try {
            if (is.available() > 0) {
                byte[] b = new byte[is.available()];
                is.read(b, 0, b.length);
                sw.write(new String(b));
            }
        } catch (IOException e) {
            sw.write(e.getMessage());
        } finally {
            return sw;
        }
    }
}