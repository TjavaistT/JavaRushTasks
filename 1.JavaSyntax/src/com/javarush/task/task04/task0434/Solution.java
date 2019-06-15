package com.javarush.task.task04.task0434;

/* 
Таблица умножения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int i = 1;
        int multiple;
        String line = "";

        while(i <= 10){
            int j = 1;
            line = "";
            while(j <= 10){
                multiple = i * j;
                line += multiple + " ";
                j++;
            }

            System.out.println(line);
            i++;
        }
    }
}
