package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        char[] alphabet = ("abcdefghijklmnopqrstuvwxyz").toCharArray();
        int countEnglishChars = 0;
        String fileName = args[0];

        try (BufferedReader bfR = new BufferedReader(new FileReader(fileName))){
            String line = null;
            while ((line = bfR.readLine()) != null){
                char[] charactersArray = line.toLowerCase().toCharArray();
                for (char character : charactersArray) {
                    for (char englishChar: alphabet){
                        if(character == englishChar){
                            countEnglishChars++;
                        }
                    }
                }
            }

            System.out.println(countEnglishChars);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
