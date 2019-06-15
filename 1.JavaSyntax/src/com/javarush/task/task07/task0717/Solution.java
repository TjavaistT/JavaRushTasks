package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = initalizeArray(10);


        ArrayList<String> result = doubleValues(list);

        result.forEach(System.out::println);
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        for (int i = list.size() -1 ; i >= 0 ; i--) {
            list.add(i+1, list.get(i));
        }
        return list;
    }

    private static ArrayList<String> initalizeArray(int count){
        ArrayList<String> list = new ArrayList<String>(count);
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < count; i++){
                list.add(scan.nextLine());

        }

        return list;
    }
}
