package com.javarush.task.task19.task1907;

import java.io.*;
import java.util.*;
import java.lang.*;
/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) {
        try (
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                FileReader scanFile = new FileReader(bufferedReader.readLine())
        ){
            StringBuilder fileContent =  new StringBuilder();

            while (scanFile.ready()){
                fileContent.append((char) scanFile.read());
            }

            String[] words = fileContent.toString().split("[^\\w+]");

            long countWords = Arrays.stream(words).filter(element -> element.equals("world")).count();

            System.out.println(countWords);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
