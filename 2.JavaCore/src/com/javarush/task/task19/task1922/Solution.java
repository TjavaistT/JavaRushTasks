package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.*;
import java.lang.*;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {

        try (
                BufferedReader readConsole = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader bufFile = new BufferedReader(new FileReader(readConsole.readLine()))
        ){
            bufFile.lines()
                    .filter(line -> countMathes(line) == 2)
                    .forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int countMathes(String line) {
        int count = 0;
        String[] arLine = line.split("\\s+");

        for (String word : arLine) if (words.contains(word)) count++;

        return count;
    }
}
