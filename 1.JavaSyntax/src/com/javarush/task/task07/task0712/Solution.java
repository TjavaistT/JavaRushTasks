package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 0712
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //получить спиок на 10 элементов
        Scanner scan = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<String>(10);
        int count = 10;

        for (int i = 0; i < count; i++){
            list.add(scan.nextLine());
        }

        //найти самую короткую/длинную строчку, которая встречается первой
        int longest, shortest;
        String resultString = list.get(count - 1);
        longest = shortest = list.get(count - 1).length();

        //нам нужна самая-самая строчка, которя встречется первой
        //с другой точки зрения, эта строчка встречается последней :)
        // count-1-1 - последний элемент уже учтен (list.get(count - 1)), можно его не сравнивать с самим собой
        for (int i = count-1-1; i >= 0; i--) {
            if (longest <= list.get(i).length()){
                longest = list.get(i).length();
                resultString = list.get(i);
            }

            if (shortest >= list.get(i).length()){
                shortest = list.get(i).length();
                resultString = list.get(i);
            }
        }

        System.out.println(resultString);
    }
}
