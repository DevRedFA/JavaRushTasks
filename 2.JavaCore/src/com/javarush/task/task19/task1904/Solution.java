package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner fileScanner;
                public PersonScannerAdapter(Scanner data) {
            this.fileScanner = data;
        }

        @Override
        public Person read() throws IOException {
            fileScanner.useDelimiter(" ");
            return new Person(fileScanner.next(), fileScanner.next(), fileScanner.next(), new Date(fileScanner.next()));
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
