package com.javarush.task.task32.task3210;

/*
Используем RandomAccessFile
*/

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class Solution {
    public static void main(String... args) {
        // просмотреть переданные аргументы
         Arrays.stream(args).forEach(System.out::println);

        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];

        try(RandomAccessFile readWriteFile = new RandomAccessFile(fileName, "rw") ) {
            byte[] findedBytes = new byte[text.getBytes().length];

            readWriteFile.seek(number);
            readWriteFile.read(findedBytes, 0, text.getBytes().length);

            String searchedText = new String(findedBytes);

            System.out.println(searchedText);

            readWriteFile.seek(readWriteFile.length());
            readWriteFile.write(String.valueOf(text.equals(searchedText)).getBytes());

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
