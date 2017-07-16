package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {

    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new ArrayList<String>();
        Files.walkFileTree(Paths.get(root), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                for (File file : dir.toFile().listFiles()) {
                    if (!file.isDirectory()) list.add(file.getAbsolutePath());
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return list;
    }

    public static void main(String[] args) throws IOException {
        for (String x : getFileTree("C:\\Users\\Rushchak\\Downloads")) {
            System.out.println(x);
        }
    }


}
