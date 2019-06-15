package com.javarush.task.task07.task0719;

import java.io.*;
import java.util.*;
import java.lang.*;
/* 
Вывести числа в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = initalizeArray(10);

        for (int i = list.size()-1; i >= 0 ; i--) {
            System.out.println(list.get(i));
        }

    }

    private static ArrayList<Integer> initalizeArray(int count){
        ArrayList<Integer> list = new ArrayList<Integer>(count);
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < count; ){
            if (scan.hasNextInt()) {
                list.add(scan.nextInt());
                i++;
            }
        }

        return list;
    }
}
