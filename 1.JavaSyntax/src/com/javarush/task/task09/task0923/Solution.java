package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String generalString = reader.readLine();
        String vowelsString = "";
        String notVowelsString = "";
        char symbol;
        char space = Character.toLowerCase(' ');

        for (int i = 0; i < generalString.length(); i++) {
            if (generalString.charAt(i) != space) {
                symbol = generalString.charAt(i);
            } else {
                continue;
            }


            if(isVowel(symbol)){
                vowelsString    += symbol + " ";
            } else {
                notVowelsString += symbol + " ";
            }
        }

        System.out.println(vowelsString);
        System.out.println(notVowelsString);
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}