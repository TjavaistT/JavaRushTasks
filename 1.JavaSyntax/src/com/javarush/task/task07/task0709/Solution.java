package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //получить спиcок на 5 элементов
        Scanner scan = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<String>(5);
        int count = 5;

        for (int i = 0; i < count; i++){
            list.add(scan.nextLine());
        }

        int shortest;
        ArrayList<String> resultStrings = new ArrayList<String>();
        resultStrings.add(0, list.get(count - 1));
        shortest = list.get(count - 1).length();

        for (int i = count-1-1; i >= 0; i--) {

            if (shortest == list.get(i).length()){
                resultStrings.add(list.get(i));
            } else if (shortest > list.get(i).length()){
                resultStrings.clear();
                shortest = list.get(i).length();
                resultStrings.add(list.get(i));
            }
        }

        for (String resultString : resultStrings) {
            System.out.println(resultString);
        }
    }
}
