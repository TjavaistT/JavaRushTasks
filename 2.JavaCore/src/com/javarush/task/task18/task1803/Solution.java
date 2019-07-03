package com.javarush.task.task18.task1803;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String filename = "";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            filename = bufferedReader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream frider = new FileInputStream(filename);
        HashMap<Integer, Integer> bytesStatistics = new HashMap<>();

        while (frider.available() > 0){
            int currentByte = frider.read();

            Integer countByte = bytesStatistics.get(currentByte);

            if ( countByte != null) {
                bytesStatistics.put(currentByte, ++countByte);
            } else {
                bytesStatistics.put(currentByte, 1);
            }
        }

        frider.close();

        //такой способ находить максиму сработает только с 8-ой Javы
        //но он более универсальный, может пригодится для смешаных значиний типа "2кг",
        // потому что мы самостоятельно определяем компаратор (сравниватель) (entry1, entry2) -> entry1.getValue() - entry2.getValue()
        int maxCountBytes = Collections.max(bytesStatistics.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getValue();

        for (Map.Entry<Integer, Integer> pair: bytesStatistics.entrySet()) {
            if(pair.getValue() == maxCountBytes){
                System.out.print(pair.getKey() + " ");
            }
        }

    }

}
