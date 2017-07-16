package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        String[] partsOfZip = Arrays.copyOfRange(args, 1, args.length);
        Arrays.sort(partsOfZip);
        String resultFileName = args[0];
        try (FileOutputStream fos = new FileOutputStream(resultFileName)) {
            List<FileInputStream> listStreams = new ArrayList<>();
            for (String fileNamePart : partsOfZip) {
                listStreams.add(new FileInputStream(fileNamePart));
            }
            try (ZipInputStream zis = new ZipInputStream(new SequenceInputStream(Collections.enumeration(listStreams)))) {
                ZipEntry ze;
                while ((ze = zis.getNextEntry()) != null) {
                    byte[] buffer = new byte[8 * 1024];
                    int length;
                    while ((length = zis.read(buffer)) > 0)  fos.write(buffer, 0, length);
                    zis.closeEntry();
                }
            }
        }
    }
}