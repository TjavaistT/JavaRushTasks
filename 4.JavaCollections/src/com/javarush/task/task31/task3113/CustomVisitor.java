package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class CustomVisitor extends SimpleFileVisitor<Path> {
    private static int directoriesCount;
    private static long directoryTotalSize;
    private static int filesCount;

    public void setDirectoriesCount(int count) {
        directoriesCount = count;
    }

    public int getDirectoriesCount() {
        //отдаем количество вложенных директорий и поддиректорий
        // за исключением родительской
        return directoriesCount -1;
    }

    public long getDirectoryTotalSize() {
        return directoryTotalSize;
    }

    public void setDirectoryTotalSize(long totalSize) {
        directoryTotalSize = totalSize;
    }

    public int getFilesCount() {
        return filesCount;
    }

    public void setFilesCount(int count) {
        filesCount = count;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (Files.isRegularFile(file)) {
            setFilesCount(getFilesCount() + 1);
            setDirectoryTotalSize(getDirectoryTotalSize() + Files.size(file));
        }
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

            setDirectoriesCount(directoriesCount + 1);

            return super.preVisitDirectory(dir, attrs);
    }
}