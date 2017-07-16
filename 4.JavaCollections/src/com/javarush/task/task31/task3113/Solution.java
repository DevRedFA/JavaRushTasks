package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {
    static Path target;
    static int filesQuantity;
    static int foldersQuantity;
    static int totalLength;

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            target = Paths.get(reader.readLine());
        }
        if (!Files.isDirectory(target)) {
            System.out.format("%s - не папка", target.toAbsolutePath().toString());
        }

        Files.walkFileTree(target, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                filesQuantity++;
                totalLength += attrs.size();
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                foldersQuantity++;
                return FileVisitResult.CONTINUE;
            }
        });

        System.out.format("Всего папок - %d%n", foldersQuantity-1);  //%d%n
        System.out.format("Всего файлов - %d%n", filesQuantity);
        System.out.format("Общий размер - %d%n", totalLength);

    }
}
