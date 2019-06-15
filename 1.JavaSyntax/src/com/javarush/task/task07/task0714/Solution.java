package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* 0714
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> arrayList = initalizeArray(5);

        arrayList.remove(2);

        Collections.reverse(arrayList);

        arrayList.forEach(System.out::println);


    }

    private static ArrayList initalizeArray(int count){
        ArrayList list = new ArrayList(count);
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < count;i++ ){
                list.add(scan.nextLine());
        }

        return list;
    }
}