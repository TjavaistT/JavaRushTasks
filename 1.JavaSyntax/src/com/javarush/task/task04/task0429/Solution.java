package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 3;
        int[] numbers = new int[count];
        String line;
        int i = 0;

        while ((line = reader.readLine()) != null ) {
            numbers[i] = Integer.valueOf(line);

            if(i == count -1) {
                break;
            }

            i++;
        }

        String countPositiveNumbers = "количество положительных чисел: ";
        String countNegativeNumbers = "количество отрицательных чисел: ";

        int PositiveIndex = 0;
        int NegativeIndex = 0;

        for (;i >= 0; i--){

            if (numbers[i] > 0) {
                PositiveIndex++;
            }

            if(numbers[i] < 0) {
                NegativeIndex++;
            }
        }

        System.out.println(countNegativeNumbers + NegativeIndex);
        System.out.println(countPositiveNumbers + PositiveIndex);
    }
}
