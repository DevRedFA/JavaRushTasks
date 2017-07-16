package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String text = args[2];
        byte[]  in = new byte[text.length()];
        try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw")) {
            raf.seek(Integer.parseInt(args[1]));
            raf.read(in, 0, in.length);
            raf.seek(raf.length());
            raf.write(convertByteToString(in).equals(text) ? "true".getBytes():"false".getBytes());
        }
    }

    private static String convertByteToString(byte[] bt) {
        return new String(bt);
    }
}

