package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String filePath = args[0];
        HashMap<Byte, Integer> bytesStatistic = new HashMap<>();
        try(FileInputStream FileInStream = new FileInputStream(filePath)) {
            byte[] fileContent = new byte[FileInStream.available()];
            FileInStream.read(fileContent);

            //Посчитать статистику встречающихся байт
            for (byte currentByte: fileContent) {
                int currentCountBytes = bytesStatistic.get(currentByte) != null ? bytesStatistic.get(currentByte)+1 : 1;
                bytesStatistic.put(currentByte, currentCountBytes);
            }
            //представить потоком
            bytesStatistic.entrySet().stream()
                    //отсортировать
                    .sorted(Comparator.comparing(Map.Entry::getKey))
                    //распечатать
                    .forEach((pair) -> System.out.println((char)(byte)pair.getKey() + " " + pair.getValue()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
