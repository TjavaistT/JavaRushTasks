package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;
import java.lang.*;
/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {

//        Э: отсортировать имена файлов - TreeSet
        TreeSet<String> filesNames = new TreeSet<>();
//        Э: считать имена файлов в список с автозакрытием потока
        try (Scanner scan = new Scanner(new InputStreamReader(System.in))) {
            String element;

            while (!(element = scan.next()).equals("end")) {
                filesNames.add(element);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
//        Э: отделить имя файла от суффикса
        String[] splitedFilename = filesNames.first().split(".part");
        String generalFilename = splitedFilename[0];
        String suffix = ".part" + splitedFilename[1];

//        Э: Создать файл с найденным именем в той же папке и открыть поток, что и считываемые файлы (буффер)(автозакрытие)
        try (
                BufferedOutputStream writeGeneralFileStream = new BufferedOutputStream(new FileOutputStream(generalFilename, true))
        ) {

            filesNames.stream()
                // получить содержимое всех файлов
                .map(Solution::getFileContent)
                    //записать содержимое в основной файл
                .forEach(fileContent -> {
                    boolean result = false;
                    try {
                        writeGeneralFileStream.write(fileContent);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //вернуть содержимое файла в массиве байт
    private static byte[] getFileContent(String filename) {
        byte[] fileContent = null;

//        Э:массив потоков файлов на чтение (автозакрытие)
        try (BufferedInputStream buf = new BufferedInputStream(new FileInputStream(filename))){
            fileContent = new byte[buf.available()];
            buf.read(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileContent;
    }
}


