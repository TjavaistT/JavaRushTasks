package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        try (
                BufferedReader scanConsole = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader bufFile = new BufferedReader(new FileReader(scanConsole.readLine()))
        ){
            String allText = bufFile.lines().reduce((str1, str2) -> str1 + "\n" + str2).orElse("");

            for (int i = 0; i < map.size(); i++) {
                allText = allText.replaceAll("\\b" + i + "\\b", map.get(i));
            }

            System.out.println(allText);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
