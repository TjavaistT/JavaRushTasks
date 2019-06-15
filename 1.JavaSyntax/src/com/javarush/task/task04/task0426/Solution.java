package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.valueOf(reader.readLine());
        String infoAboutNumber = "ноль";

        if(number > 0) {
            infoAboutNumber = "положительное ";
        }else if(number < 0) {
            infoAboutNumber = "отрицательное ";
        }

        if(number % 2 == 0 && number != 0){
            infoAboutNumber += "четное число";
        } else if(number % 2 == 1 || number % 2 == -1){
            infoAboutNumber += "нечетное число";
        }

        System.out.println(infoAboutNumber);
    }

}
