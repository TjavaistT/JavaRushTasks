package com.javarush.task.task18.task1804;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String filename = new Scanner(System.in).nextLine();

        //по условий необходимо использовать FileInputStream - поэтому здесь код, как в старых версиях Java
        ArrayList<Integer> bytes = new ArrayList<>();
        try (InputStream frider = new FileInputStream(new File(filename))) {


            while (frider.available() > 0) {
                bytes.add(frider.read());
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        //с помощью группировки подсчитывается сколько раз встречается каждый байт
        Map<Object, Long> bytesStatistics = bytes.stream().collect(Collectors.groupingBy((v)-> v, Collectors.counting()));
        //найти минимальное количество раз , которое встречается байт
        Long min = Collections.min(bytesStatistics.values());
        //выводит на экран байты, которые встречаются минимальное количество раз
        bytesStatistics.entrySet().stream()
                //отфильтровать пары, в которых значение равно минимуму
                .filter(e -> e.getValue().equals(min))
                //выбрать из пар значения байтов
                .map(Map.Entry::getKey)
                //выводит на экран через пробел все байты
                .forEach((k) -> System.out.print(k + " "));
    }
}
