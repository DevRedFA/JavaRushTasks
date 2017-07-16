package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        try (BufferedReader fileAllReader = new BufferedReader(new FileReader(consoleReader.readLine()))) {
            while (fileAllReader.ready()) {
                allLines.add(fileAllReader.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (BufferedReader fileRemoveReader = new BufferedReader(new FileReader(consoleReader.readLine()))) {
            while (fileRemoveReader.ready()) {
                forRemoveLines.add(fileRemoveReader.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            new Solution().joinData();
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
