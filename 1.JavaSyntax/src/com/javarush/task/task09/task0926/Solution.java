package com.javarush.task.task09.task0926;

import java.util.ArrayList;
import java.util.Random;

/* 0926 - Матрица подкралась назаметно :)
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        Random random = new Random();
        ArrayList<int[]> list = new ArrayList<>(5);
        int[] sizesInnerArrays = {5, 2, 4, 7, 0};

        for (int j = 0; j < sizesInnerArrays.length; j++) {
            int[] numbers = new int[sizesInnerArrays[j]];

            for (int k = 0; k < numbers.length; k++) {
                numbers[k] = random.nextInt(99);
            }

            list.add(numbers);
        }

       return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
