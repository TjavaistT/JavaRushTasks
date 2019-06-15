package com.javarush.task.task07.task0728;

import java.io.*;
import java.util.*;

/* 0728 - Сортировка слиянием
В убывающем порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {

        //Джава капризная леди - вот так в array обработанный массив не попадет
        // (пока не понял почему)
        //array = sortMerge(array);

        //а вот если значения впихивать по одному - то исходный массив в главной функции будет изменен
        int [] sortArray = sortMerge(array);
        for(int i = 0; i < array.length; i++) {
            array[i] = sortArray[i];
        }
    }

    private static int[] sortMerge(int[] arr) {

        int len = arr.length;
        if (len < 2) return arr;
        int middle = len / 2;

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, len);

        return merge(sortMerge(left),
                sortMerge(right));
    }

    private static int[] merge(int[] arr_1, int[] arr_2) {
        int len_1 = arr_1.length, len_2 = arr_2.length;
        int a = 0, b = 0, len = len_1 + len_2; // a, b - счетчики в массивах
        int[] result = new int[len];

        for(int i = 0; i < len; i++){
            if(a < len_1 && b < len_2){
                if(arr_1[a] > arr_2[b]) {
                    result[i] = arr_1[a++];
                }else {
                    result[i] = arr_2[b++];
                }
            } else if (a < len_1){
                result[i] = arr_1[a++];
            } else {
                result[i] = arr_2[b++];
            }

        }
        return result;
    }
}
