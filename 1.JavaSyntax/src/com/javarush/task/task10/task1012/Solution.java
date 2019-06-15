package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.lang.*;

/* Задача 1012
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        //подсчет сколько раз символ встречается в строке
        int count = 0;

        for (Character character : alphabet) {
            for (String line: list) {
                // народный способ подсчета количества данного символа в строке
//                count += line.length() - line.replace(character.toString(), "").length();;

                //современный способ1
//                count += line.codePoints().filter(ch -> ch == character).count();

                //современный способ2
                count += line.chars().filter(ch -> ch == character).count();

            }
            System.out.println(character.toString() + " " + count);
            count = 0;
        }
    }
}
