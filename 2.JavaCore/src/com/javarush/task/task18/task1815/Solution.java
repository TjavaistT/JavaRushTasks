package com.javarush.task.task18.task1815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        char [] chArr = string.toCharArray();
        chArr[0] = Character.toUpperCase(chArr[0]);
        for (int i = 1; i < chArr.length; i ++) {
            if (chArr[i] == ' ') {
                chArr[i+1] = Character.toUpperCase(chArr[i+1]);
            }
        }
        System.out.println(String.valueOf(chArr));
    }
}