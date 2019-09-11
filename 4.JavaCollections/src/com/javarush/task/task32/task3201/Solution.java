package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        // просмотреть переданные аргументы
        // Arrays.stream(args).forEach(System.out::println);

        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];

        try(RandomAccessFile readWriteFile = new RandomAccessFile(fileName, "rw")){
            long fileLenth = readWriteFile.length();
            if(number > fileLenth) number = fileLenth;

            readWriteFile.seek(number);
            readWriteFile.write(text.getBytes());

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
