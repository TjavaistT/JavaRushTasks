package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String[] arStrings = new String[10];
        int[] arInt = new int[10];

        for(int i = 0; i < 10; i++){
            arStrings[i] = scan.nextLine();
            arInt[i] = arStrings[i].length();
        }

        for (int lineLength : arInt){
            System.out.println(lineLength);
        }
    }
}
