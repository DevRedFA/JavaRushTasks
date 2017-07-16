package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        String name = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintStream out = System.out;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream console = new PrintStream(stream);
        System.setOut(console);
        testString.printSomething();
        try (FileOutputStream writer = new FileOutputStream(name)) {
            writer.write(stream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setOut(out);
        System.out.println(stream.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

