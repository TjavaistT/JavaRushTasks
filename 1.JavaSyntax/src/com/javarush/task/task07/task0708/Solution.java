package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 0708
Самая длинная строка
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        strings = new ArrayList<String>();
        ArrayList<String> longerStrings = new ArrayList<String>();
        longerStrings.add("");
        Scanner scan = new Scanner(System.in);


        for (int i = 0; i < 5; i++) {
            strings.add(scan.nextLine());
        }

        for (String string : strings) {
            if(string.length() > longerStrings.get(0).length()){
                // если нашлось большее значение, то массив можно очистить
                longerStrings.clear();
                longerStrings.add(string);
            } else if(string.length() == longerStrings.get(0).length()){
                //если переданное значение по длине равно максимальному, то его тоже стоит запомнить
                longerStrings.add(string);
            }
        }

        for (String string : longerStrings) {
            System.out.println(string);
        }
    }
}
