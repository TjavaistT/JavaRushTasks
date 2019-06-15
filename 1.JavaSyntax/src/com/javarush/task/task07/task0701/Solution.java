package com.javarush.task.task07.task0701;

import java.io.*;
import java.util.*;

/* 0701
Массивный максимум
*/

public class Solution {
    private static int count = 20;
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        Scanner scan = new Scanner(System.in);
        int[] array = new int[count];

        for (int i = 0; i < count; i++){
            if (scan.hasNextInt()) {
                array[i] = scan.nextInt();
            }
        }
        return array;
    }

    public static int max(int[] array) {
        Arrays.sort(array);
        return array[count-1];
    }
}
