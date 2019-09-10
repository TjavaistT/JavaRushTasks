package com.javarush.task.task31.task3107;

import java.nio.file.*;

/*
Null Object Pattern
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        try {
            Path pathFile = Paths.get(pathToFile);
            this.fileData = new ConcreteFileData(
                    Files.isHidden(pathFile),
                    Files.isExecutable(pathFile),
                    Files.isDirectory(pathFile),
                    Files.isWritable(pathFile));
        } catch (Exception e) {
            this.fileData = new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
