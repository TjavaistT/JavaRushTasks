package com.javarush.task.task19.task1919;

/* Задача 1919
Считаем зарплаты
*/
import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        try (
            BufferedReader fileStream = new BufferedReader(new FileReader(args[0]))
        ) {
            //предствить файл потоком строк
            Map<String, Double> salarys = fileStream.lines()
                    //каждую строку предствить как массив - с именем и значением зарпаты
                    .map(line -> line.split("\\s+"))
                    //создать массив сгруппированный по именам
                    .collect(
                            //групировать по именам
                            Collectors.groupingBy(pay -> pay[0],
                            //а значения выплат привести к дробному числу и сложить
                            Collectors.summingDouble(pay -> Double.parseDouble(pay[1]))
                            ));

            salarys.entrySet().stream()
                    //отсортировать по именам
                    .sorted(Comparator.comparing(Map.Entry::getKey))
                    //вывести на экран
                    .forEach(pair -> System.out.println(pair.getKey() + " " + pair.getValue()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Double> summaryPays(String[] pay1, String[] pay2){
        Map<String, Double> resultMap = new TreeMap<>();
        String name1 = pay1[0];
        String name2 = pay2[0];
        Double moneyCount1 = Double.parseDouble(pay1[1]);
        Double moneyCount2 = Double.parseDouble(pay2[1]);

        if(name1.equals(name2)){
            resultMap.put(name1, moneyCount1 + moneyCount2);
        } else {
            resultMap.put(name1, moneyCount1);
            resultMap.put(name2, moneyCount2);
        }

        return resultMap;
    }
}
