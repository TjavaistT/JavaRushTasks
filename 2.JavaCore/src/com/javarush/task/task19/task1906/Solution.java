package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;
/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) {
        try(
            BufferedReader consoleBufR = new BufferedReader(new InputStreamReader(System.in));
            FileReader fileReader = new FileReader(consoleBufR.readLine());
            FileWriter fileWriter = new FileWriter(consoleBufR.readLine())
        ){
            List<Integer> fileContent = new ArrayList<>();
            while (fileReader.ready()) fileContent.add(fileReader.read());

            for (int i = 0; i < fileContent.size(); i++) {
                if (i % 2 != 0){
                    fileWriter.write(fileContent.get(i));
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
