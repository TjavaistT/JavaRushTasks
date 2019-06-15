package com.javarush.task.task07.task0721;

import java.io.*;
import java.util.*;
import java.lang.*;
/*
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] arrayInt = new int[20];
        arrayInt = initalizeArrayInt(arrayInt);
//        int[] arrayInt = randomArrayInt(count);

        int minimum, maximum;
        minimum = maximum = arrayInt[0];

        for (int i = 1; i < arrayInt.length; i++) {

            if (arrayInt[i] > maximum){
                maximum = arrayInt[i];
            }

            if (arrayInt[i] < minimum) {
                minimum = arrayInt[i];
            }

        }

        System.out.print(maximum + " " + minimum);
    }

    private static int[] randomArrayInt(int count) {
        Random random = new Random();
        int[] numbers = new int[count];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(99);
        }

        return numbers;
    }

    private static int[] initalizeArrayInt(int[] list){
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < list.length; ){
            if (scan.hasNextInt()) {
                list[i]  = scan.nextInt();
                i++;
            }
        }

        return list;
    }
}