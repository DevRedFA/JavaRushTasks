package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    @Override

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean isGood = true;
        long fileSize = Files.size(file);
        if (partOfName != null && !file.getFileName().toString().contains(partOfName)) isGood = false;

        if (partOfContent != null && (!(new String(Files.readAllBytes(file)).contains(partOfContent)))) isGood = false;

        if (maxSize != 0 && fileSize > maxSize) isGood = false;

        if (minSize != 0 && fileSize < minSize) isGood = false;

        if (isGood) foundFiles.add(file);

        return super.

                visitFile(file, attrs);

    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }


}



