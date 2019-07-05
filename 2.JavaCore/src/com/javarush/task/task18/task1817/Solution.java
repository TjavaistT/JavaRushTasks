package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        int countChars = 0;
        int countSpaces = 0;
        String fileName = args[0];

        try (FileInputStream fileInpStrim = new FileInputStream(fileName)){
            while (fileInpStrim.available() > 0){
                countChars++;

                if((char) fileInpStrim.read() == (char) ' '){
                    countSpaces++;
                }
            }

            System.out.printf("%.2f", Double.valueOf(countSpaces)/Double.valueOf(countChars)*100);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
