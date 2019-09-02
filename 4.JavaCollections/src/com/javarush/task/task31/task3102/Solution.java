package com.javarush.task.task31.task3102;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* 
Находим все файлы
*/
public class Solution {

    static List<String> fileTree = new ArrayList<>();

    public static List<String> getFileTree(String root) throws IOException {

        SimpleFileVisitor<Path> visitor = new CustomVizitFile();
        Files.walkFileTree(Paths.get(root), visitor);

        return fileTree;
    }

    public static void main(String[] args) {
//        try {
//            List<String> pats = getFileTree("/home/vaist/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task31/task3102/test_dir1");
//            pats.forEach(System.out::println);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


}

class CustomVizitFile extends SimpleFileVisitor<Path>{

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

        Objects.requireNonNull(file);
        Objects.requireNonNull(attrs);

        if(!attrs.isDirectory()) Solution.fileTree.add(file.toAbsolutePath().toString());

        return FileVisitResult.CONTINUE;
    }
}
