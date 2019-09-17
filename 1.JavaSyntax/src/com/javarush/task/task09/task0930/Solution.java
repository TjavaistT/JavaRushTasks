package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/* 
Задача по алгоритмам
Необходимо массив разобрать на
- взять из массива все числа и отсортироват
- взять оставшиеся строки и отсортировать
- вставить обратно
*/

public class Solution {

    static String[] array = new String[0];

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //структура массива - т.е. номера ячеек с типами значений которые в них должны быть
        ArrayList<String> structure = new ArrayList<>(array.length);
        //массив чисел
        ArrayList<Integer> numbers = new ArrayList<>();
        //массив строк
        ArrayList<String> lines = new ArrayList<>();

        //вырезаем из массива числа и строки
        for (String x : array) {
            if (isNumber(x)) {
                numbers.add(Integer.valueOf(x));
                structure.add("number");
            } else {
                lines.add(x);
                structure.add("string");
            }
        }

        // сортировка по возрастанию
        // список преобразоват в массив - массив отсортировать - преобразовать обратно в список
        lines = (ArrayList<String>) lines.stream().sorted((a, b) -> isGreaterThan(a, b) ? 1 : -1).collect(Collectors.toList());

        // сортировка по убыванию
        numbers = (ArrayList<Integer>) numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        for (int i = 0; i < structure.size(); i++) {
            String element = structure.get(i);

            if (element.equals("string")) {
                element = lines.get(0);
                lines.remove(0);
            }

            if (element.equals("number")) {
                element = String.valueOf(numbers.get(0));
                numbers.remove((int) 0);
            }

            Solution.array[i] = element;
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
