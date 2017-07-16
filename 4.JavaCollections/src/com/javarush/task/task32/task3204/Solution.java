package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Random random = new java.util.Random();
        byte[] bytes = new byte[8];
        byte[] bytes2 = new byte[8];
//        random.setSeed(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append((char) ((random.nextInt(10)) + '0'));
        sb.append((char) ((random.nextInt(26)) + 'a'));
        sb.append((char) ((random.nextInt(26)) + 'A'));
        for (int i = 3; i < bytes.length; ++i) {
            char next = 0;
            int range = 10;

            switch (random.nextInt(3)) {
                case 0: {
                    next = '0';
                    range = 10;
                }
                break;
                case 1: {
                    next = 'a';
                    range = 26;
                }
                break;
                case 2: {
                    next = 'A';
                    range = 26;
                }
                break;
            }

            sb.append((char) ((random.nextInt(range)) + next));
        }
        bytes = sb.toString().getBytes();
        for (int i = 0; i < bytes.length; ) {
            int r = random.nextInt(bytes.length);
            if (bytes[r] != 127) {
                bytes2[i++] = bytes[r];
                bytes[r] = 127;
            }
        }

        stream.write(bytes2);
        return stream;
    }
}