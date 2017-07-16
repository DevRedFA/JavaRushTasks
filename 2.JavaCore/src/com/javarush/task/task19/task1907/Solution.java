package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        String in;
        int cnt = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            in = reader.readLine();

        }
        StringBuilder sb = new StringBuilder();
        try (FileReader freader = new FileReader(in)) {
            while (freader.ready()) {
                sb.append((char) freader.read());
            }
            String[] s = sb.toString().split("[^\\w]");
            for (String st : s) {
                if (st.equals("world")) {
                    cnt++;
                }
            }

        }

        System.out.println(cnt);
    }
}
