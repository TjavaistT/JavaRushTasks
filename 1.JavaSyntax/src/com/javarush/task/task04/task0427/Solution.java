package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.valueOf(reader.readLine());
//        int number = 257;
        String infoAboutNumber = "";
        if(1 <= number && number <= 999){
            if(number % 2 == 0){
                infoAboutNumber = "четное ";
            } else if (number % 2 == 1){
                infoAboutNumber = "нечетное ";
            }

            if(1 <= number && number <= 9){
                infoAboutNumber += "однозначное число";
            } else if(10 <= number && number <= 99){
                infoAboutNumber += "двузначное число";
            } else if(100 <= number && number <= 999){
                infoAboutNumber += "трехзначное число";
            }

            System.out.println(infoAboutNumber);
        }
    }
}
