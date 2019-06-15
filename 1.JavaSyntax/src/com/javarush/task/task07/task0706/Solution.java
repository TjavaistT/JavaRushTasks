package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] houses = new int[15];
        int sumEven = 0;
        int sumOdd = 0;

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 15; i++){
            if (scan.hasNextInt()) {
                houses[i] = scan.nextInt();
            }
        }

        for(int i = 0; i < houses.length; i++){
            if(i % 2 == 0){
                sumEven += houses[i];
            } else {
                sumOdd += houses[i];
            }
        }

        if(sumEven > sumOdd){
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }

        if(sumEven < sumOdd){
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }

    }
}
