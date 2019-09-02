package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) {
        Path filePath = Paths.get(args[0]);
        String  nameNewDirectoryForFileInArchive = "new";
        Map<String, ByteArrayOutputStream> files = new HashMap<>();

        //сохранить все что было в архиве
        try(
            FileInputStream fis = new FileInputStream(args[1]);
            ZipInputStream zStreamRead = new ZipInputStream(fis)
        ) {
            ZipEntry entry;
            while ((entry = zStreamRead.getNextEntry()) != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count;
                while ((count = zStreamRead.read(buffer)) > 0 ){
                    baos.write(buffer, 0, count);
                }

                files.put(entry.getName(), baos);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        //записать новый файл и то что было раньше в архиве
        try(
            FileOutputStream fos = new FileOutputStream(args[1]);
            ZipOutputStream zStreamWrite = new ZipOutputStream(fos)
        ) {
            for (Map.Entry<String, ByteArrayOutputStream> file : files.entrySet()) {
                if(file.getKey().substring(file.getKey().lastIndexOf("/") + 1).equals(filePath.getFileName().toString())) continue;
                zStreamWrite.putNextEntry(new ZipEntry(file.getKey()));
                zStreamWrite.write(file.getValue().toByteArray());
            }

            ZipEntry entry = new ZipEntry(nameNewDirectoryForFileInArchive + "/" + filePath.getFileName().toString());
            zStreamWrite.putNextEntry(entry);
            Files.copy(filePath, zStreamWrite);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}