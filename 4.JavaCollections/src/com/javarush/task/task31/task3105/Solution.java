package com.javarush.task.task31.task3105;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;

import java.util.*;
import java.util.zip.*;


/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path fileName = Paths.get(args[0]);
        Map<ZipEntry, byte[]> map = new HashMap<>();
        ZipEntry entry;
        long entrySize;
        byte[] temp;
        int counter = 0;
        try (ZipInputStream stream = new ZipInputStream(new FileInputStream(args[1]))) {
            while ((entry = stream.getNextEntry()) != null) {
                if (entry.isDirectory()) {
                    continue;
                }
                entrySize = entry.getSize();
                if (entrySize < 1) {
                    map.put(entry, new byte[0]);
                    continue;
                }
                temp = new byte[(int) entrySize];
                while (counter < entrySize) {
                    temp[counter] = (byte) stream.read();
                    counter++;
                }
                counter = 0;
                map.put(entry, temp);
            }
        }
        boolean isReplaced = false;
        String nameZip = null;
        ZipEntry newE;
        try (ZipOutputStream stream = new ZipOutputStream(new FileOutputStream(args[1]))) {
            for (Map.Entry<ZipEntry, byte[]> zipEnt : map.entrySet()) {

                if (zipEnt.getKey().getName().substring(zipEnt.getKey().getName().lastIndexOf("/") + 1).equals(fileName.getFileName().toString())) {
                    isReplaced = true;
                    nameZip = zipEnt.getKey().getName();
                } else {
                    stream.putNextEntry(zipEnt.getKey());
                    stream.write(zipEnt.getValue());
                    stream.closeEntry();
                }
            }

            if (isReplaced == false) {
                newE = new ZipEntry(("new/" + fileName.getFileName().toString()));
            } else {
                newE = new ZipEntry(nameZip);
            }
            newE.setSize(Files.size(fileName));
            stream.putNextEntry(newE);
            Files.copy(fileName, stream);
            stream.closeEntry();
        }
    }
}

