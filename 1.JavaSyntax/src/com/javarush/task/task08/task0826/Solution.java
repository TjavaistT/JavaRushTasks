package com.javarush.task.task08.task0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Пять победителей
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    //лень до меня добралась - не хочу быть линейным изоморфом
    //сортирую массив по-возрастанию и вспомогательным массивом меняю массив задом наперед, чтобы  массив стал по-убыванию
    //с примитвами int[] по другому не получается
    public static void sort(int[] array) {
        int[] reverseArray = new int[array.length];
        Arrays.sort(array);
        for (int i = 0; i < reverseArray.length; i++) {
            reverseArray[i] = array[array.length -1 - i ];
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = reverseArray[i];
        }
    }
}
