package com.javarush.task.task07.task0720;

import java.io.*;
import java.util.*;
import java.lang.*;

/*
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        Integer[] arParams = initalizeParameters(2);

        int countN = arParams[0];
        int countM = arParams[1];

        ArrayList<String> list = initalizeArrayStrings(countN);

        replaceElementsToEnd(list, countM);

        list.forEach(System.out::println);
    }

    private static void replaceElementsToEnd(ArrayList<String> list, int countM) {
        for (int i = 0; i < countM; i++) {
            list.add(list.remove(0));
        }
    }

    private static ArrayList<String> initalizeArrayStrings(int count) {
        ArrayList<String> list = new ArrayList<String>(count);
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < count; i++) {
            list.add(scan.nextLine());
        }

        return list;
    }

    private static Integer[] initalizeParameters(int count) {
        Integer[] list = new Integer[count];
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < count; i++) {
            if (scan.hasNextInt()) {
                list[i] = scan.nextInt();
            }
        }

        return list;
    }
}
