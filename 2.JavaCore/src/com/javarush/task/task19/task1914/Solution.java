package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);


        testString.printSomething();
        System.setOut(consoleStream);
        String st = outputStream.toString();
        String[] s = st.split(" ");
        int res=0;
        switch (s[1]) {
            case "+":
                res = Integer.parseInt(s[0]) + Integer.parseInt(s[2]);
                break;
            case "-":
                res = Integer.parseInt(s[0]) - Integer.parseInt(s[2]);
                break;
            case "*":
                res = Integer.parseInt(s[0]) * Integer.parseInt(s[2]);
                break;
            case "/":
                res = Integer.parseInt(s[0]) / Integer.parseInt(s[2]);
                break;
        }
        System.out.println(st + res);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println( "3 + 6 = ");
        }
    }
}

