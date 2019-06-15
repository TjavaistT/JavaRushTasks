package com.javarush.task.task04.task0433;


/* 
Гадание на долларовый счет
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int i = 1;
        int j = 1;
        String line = "";

        while(i <= 10){
            while(j <= 10){
                line += "S";
                j++;
            }
            System.out.println(line);
            i++;
        }
    }
}
