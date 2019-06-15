package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.valueOf(reader.readLine());
        int countPositive = 0;

        if(first >0){
            countPositive++;
        }

        int second = Integer.valueOf(reader.readLine());
        if(second > 0){
            countPositive++;
        }

        int third = Integer.valueOf(reader.readLine());
        if(third > 0){
            countPositive++;
        }

        System.out.println(countPositive);
    }
}
