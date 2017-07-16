package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import javafx.beans.binding.StringBinding;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
//        StringBuilder sb = new StringBuilder();
        byte mask = 100;
        if (args[0].equals("-e")) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[1])))) {
                while (reader.ready())
                    list.add(reader.read());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (BufferedWriter reader = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[2])))) {
                for (int b : list) {
                    reader.write(b ^ mask);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (args[0].equals("-d")) {

            byte b = 0;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[1])))) {
                while (reader.ready()) {
                    b = (byte) reader.read();
                    list2.add(b ^ mask);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (BufferedWriter reader = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[2])))) {
                for (Integer i : list2) {
                    reader.write(i);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
