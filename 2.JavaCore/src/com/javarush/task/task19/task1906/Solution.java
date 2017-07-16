package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String in, out;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            in = reader.readLine();
            out = reader.readLine();
        }
        try (FileReader ireader = new FileReader(in)) {
            try (FileWriter oreader = new FileWriter(out)) {
                while (ireader.ready()) {
                    ireader.read();
                    oreader.write(ireader.read());
                }
            }
        }
    }
}
