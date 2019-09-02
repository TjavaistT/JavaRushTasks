package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Что внутри папки?
*/
public class Solution {
    public static void main(String[] args) {
        try(BufferedReader bis = new BufferedReader(new InputStreamReader(System.in))){
            Path directory = Paths.get(bis.readLine());
            if(Files.isDirectory(directory)){
                CustomVisitor visitor = new CustomVisitor();
                Files.walkFileTree(directory, visitor);

                System.out.println("Всего папок - " + visitor.getDirectoriesCount());
                System.out.println("Всего файлов - " + visitor.getFilesCount());
                System.out.println("Общий размер - " + visitor.getDirectoryTotalSize());
            } else {
                System.out.println(directory.toAbsolutePath().toString() + " - не папка");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
