package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/
import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        try(
            BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]))
            ){
            fileReader.lines()
                //каждую строку разбить по пробелам, чтоб получить поток слов
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                //отфильтровать
                .filter(word -> !word.replaceAll("\\d", "").equals(word))
                //записать в файл
                .forEach(word -> Solution.writeToFile(fileWriter, word));

            }catch (Exception e){
                e.printStackTrace();
            }
    }

    private static void writeToFile(BufferedWriter fileWriter, String word) {
        try {
            fileWriter.write(word);
            fileWriter.write(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
