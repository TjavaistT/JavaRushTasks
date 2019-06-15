package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] arrayInt = new int[10];
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 10; i++){
            if (scan.hasNextInt()) {
                arrayInt[i] = scan.nextInt();
            }
        }

        for(int j = arrayInt.length - 1; j >= 0; j--){
            System.out.println(arrayInt[j]);
        }
    }
}

