package com.javarush.task.task07.task0702;

import java.io.*;
import java.util.*;

/*  0702
Массив из строчек в обратном порядке
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        String[] array = new String[10];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 8; i++) {
                array[i] = scan.nextLine();
        }

        for(int i = array.length-1; i >=0; i--){
            System.out.println(array[i]);
        }
    }
}