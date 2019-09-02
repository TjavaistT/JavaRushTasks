package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* Задача 3101
Проход по дереву файлов
*/
public class Solution {

    public static void main(String[] args) {

        File directory = new File(args[0]);
        File oldResultFile = new File(args[1]);
        File newFileResult = new File(oldResultFile.getParent() + "/allFilesContent.txt");
        //переименовать файл результата
        FileUtils.renameFile(oldResultFile, newFileResult);
        //и создать поток записи
        try (FileOutputStream writeResult = new FileOutputStream(newFileResult, true)){

            //получить все файлы в директории и поддиректории
            List<File> allFiles = getAllLittleFiles(
                    Objects.requireNonNull(
                            directory.listFiles()
                    ));

            //отобрать мальнькие и отсортировать
            File[] littleFiles = allFiles.stream()
                    .filter(file -> file.length() <= 50)
                    .sorted(Comparator.comparing(File::getName))
                    .toArray(File[]::new);

            for (File file : littleFiles) {
                BufferedInputStream readFile = new BufferedInputStream(new FileInputStream(file));

                byte[] fileContent = new byte[readFile.available()];
                int countReadedChars = readFile.read(fileContent);

                if (countReadedChars > 0) {
                    writeResult.write(fileContent);
                    writeResult.write(("\n").getBytes());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static List<File> getAllLittleFiles(File[] files) {
        List<File> result = new ArrayList<>();
        for (File file : files) {
            if(file.isDirectory()){
                result.addAll(getAllLittleFiles(Objects.requireNonNull(file.listFiles())));
            } else {
                result.add(file);
            }
        }

        return result;
    }
}
