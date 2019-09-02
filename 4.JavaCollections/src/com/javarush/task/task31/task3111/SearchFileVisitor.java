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

    private String partOfName = null;
    private String partOfContent = null;
    private int minSize;
    private int maxSize;

    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length

        boolean moreThenMin = minSize == 0 || content.length > minSize;
        boolean lessThenMax = maxSize == 0 || content.length < maxSize;
        boolean containPartName = getPartOfName() == null || String.valueOf(file.getFileName()).contains(getPartOfName());
        boolean containPartContent = getPartOfContent() == null || new String(content).contains(getPartOfContent());

        if(moreThenMin
            && lessThenMax
            && containPartName
            && containPartContent
        )
        {
            foundFiles.add(file);
        }
        return super.visitFile(file, attrs);
    }


    public String getPartOfName() {
        return partOfName;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public int getMinSize() {
        return minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setPartOfName(String text) {
        this.partOfName = text;
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
