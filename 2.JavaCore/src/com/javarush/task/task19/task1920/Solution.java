package com.javarush.task.task19.task1920;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.lang.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) {
        try (
                BufferedReader bufInpStream = new BufferedReader(new FileReader(args[0]))
        ){

            Map<String, Double> salarys = bufInpStream.lines()
                    .map(line -> line.split(" "))
                    .collect(
                            Collectors.groupingBy(pay -> pay[0],
                                    Collectors.summingDouble(pay -> Double.parseDouble(pay[1])
                                    )
                            )
                    );

            Double max = salarys.entrySet().stream()
                    .max(Comparator.comparing(Map.Entry::getValue)).get().getValue();

            salarys.entrySet().stream()
                    .filter(pair-> pair.getValue().equals(max))
                    .forEach(pair -> System.out.println(pair.getKey()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
