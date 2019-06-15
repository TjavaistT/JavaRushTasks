package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] arrayIntBig = new int[20];
        int[] arrayIntSmall1 = new int[10];
        int[] arrayIntSmall2 = new int[10];

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 20; i++){
            if (scan.hasNextInt()) {
                arrayIntBig[i] = scan.nextInt();
            }
        }

        arrayIntSmall1 = Arrays.copyOfRange(arrayIntBig, 0, 10);
        arrayIntSmall2 = Arrays.copyOfRange(arrayIntBig, 10, 20);

        for (int number : arrayIntSmall2) {
            System.out.println(number);
        }
    }
}
