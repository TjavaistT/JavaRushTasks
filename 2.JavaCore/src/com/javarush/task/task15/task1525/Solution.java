package com.javarush.task.task15.task1525;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/
public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        //Короткое и  не понятное
        try {
            Files.lines(Paths.get(Statics.FILE_NAME)).forEach(lines::add);
            //если выводит в неверной кодировку - вот так правится Files.lines(Paths.get(Statics.FILE_NAME), StandardCharsets.UTF_8)
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Длинное, но понятное решение (валидатор не проходит)
        /* BufferedReader bufferedReader = null;
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(Statics.FILE_NAME);
            bufferedReader = new BufferedReader(fileReader);

            Solution.lines = new ArrayList<String>();
            String line;

            while (bufferedReader.ready()){
                line = bufferedReader.readLine();
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
