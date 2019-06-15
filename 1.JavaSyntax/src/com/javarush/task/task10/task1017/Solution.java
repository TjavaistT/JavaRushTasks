package com.javarush.task.task10.task1017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Безопасное извлечение из списка
странное условие - если мы запросим из списка элемент, которого там нет - перехватить ошибку
а то что в процессе создания самого списка может быть ошибка, когда мы ждем число, а получаем строку - всем пофигу
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            int x = Integer.parseInt(reader.readLine());

            System.out.println("x");
            System.out.println(x);

            list.add(x);
        }

        System.out.println(safeGetElement(list, 5, 1));
        System.out.println(safeGetElement(list, 20, 7));
        System.out.println(safeGetElement(list, -5, 9));
    }

    public static int safeGetElement(ArrayList<Integer> list, int index, int defaultValue) {
        try {
            return list.get(index);
        } catch (Exception e){
            return defaultValue;
        }
    }

}
