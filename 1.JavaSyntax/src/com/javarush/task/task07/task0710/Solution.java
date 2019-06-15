package com.javarush.task.task07.task0710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
В начало списка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> arrayListStr = new ArrayList<String>(10);
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 10; i++){
            arrayListStr.add(0, scan.nextLine());
        }

        for (String element :
                arrayListStr) {
            System.out.println(element);
        }
    }
}
