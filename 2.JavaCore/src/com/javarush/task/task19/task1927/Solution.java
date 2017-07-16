package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.*;


public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        String[] st = result.split(System.lineSeparator());
        System.setOut(consoleStream);
        for (int i = 0; i < st.length; i++) {
            System.out.println(st[i]);
            if (i % 2 == 1) System.out.println("JavaRush - курсы Java онлайн");
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
