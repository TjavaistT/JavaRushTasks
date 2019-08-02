package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/
import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
    try(
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]))
        ){
        String words = fileReader.lines()
            //каждую строку разбить по пробелам, чтоб получить поток слов
            .flatMap(line -> Arrays.stream(line.split("\\s+")))
            //отфильтровать
            .filter(word -> word.length() > 6)
            //записать в строку через запятую
            .collect(Collectors.joining(","));

        fileWriter.write(words);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
