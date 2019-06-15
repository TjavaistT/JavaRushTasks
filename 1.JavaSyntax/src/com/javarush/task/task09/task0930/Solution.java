package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Задача по алгоритмам
Необходимо массив разобрать на
- взять из массива все числа и отсортироват
- взять оставшиеся строки и отсортировать
- вставить обратно
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
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
            } else {
                lines.add(x);
            }
        }

        // сортировка по возрастанию
        // список преобразоват в массив - массив отсортировать - преобразовать обратно в список
        lines = (ArrayList<String>) Arrays.asList(sortMergeAsc(lines.toArray(new String[0])));

        // сортировка по убыванию
//        sortMergeDesc(numbers);

        for (int i = 0; i < array.length; i++){
            if(isNumber(array[i])){
                array[i] = String.valueOf(numbers.get(0));
                numbers.remove(0);
            } else {
                array[i] = lines.get(0);
                lines.remove(0);
            }
        }
    }

    //Метод сортировки строк
    public static String[] sortMergeAsc(String[] lines){
        String[] resultSort = new String[lines.length];

        if (lines.length == 1){
            resultSort = lines;
        } else {

            int half = lines.length / 2;

            String[] firstArray = sortMergeAsc(Arrays.copyOfRange(lines, 0 , half));
            String[] secondArray = sortMergeAsc(Arrays.copyOfRange(lines, half, lines.length - 1));
            int i = 0;
            int j = 0;

            for (int n = 0; n < (firstArray.length + secondArray.length-1); n++) {
                if (isGreaterThan(firstArray[i], secondArray[j])) {
                    resultSort[n] = firstArray[i];
                    i++;
                } else {
                    resultSort[n] = secondArray[j];
                    j++;
                }
            }
        }

        return resultSort;
    }

    //Метод сортировки чисел
    public static void sortMergeDesc(ArrayList<Integer> lines){

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
