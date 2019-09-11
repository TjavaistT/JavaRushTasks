package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        //сгенерировать пароль
        int[] passwordInt = new Random().ints(50,48, 122)
                .filter(i -> i <= 57 || (65 <= i && i <= 90) || 97 <= i)
                .limit(8)
                .toArray();

        //проверить присутвуют ли в нем все 3 категории символов
        ByteArrayOutputStream pass = new ByteArrayOutputStream();
        //количество символов разных категорий в пароле, категории 3 - малые литеры, большие и числа
        int[] countSymbolsOfCategories = new int[]{0, 0, 0};
        for (int number : passwordInt) {
            if(48 < number && number < 58) countSymbolsOfCategories[0]++;
            if(65 < number && number < 90) countSymbolsOfCategories[1]++;
            if(97 < number && number < 122) countSymbolsOfCategories[2]++;

            pass.write((byte) number);
        }

        int allCategoriesInPass = 1;
        for (int number : countSymbolsOfCategories) {
            allCategoriesInPass *= number;
        }
        //если не присутствуют - еще раз пароль поискать
        if(allCategoriesInPass == 0) pass = getPassword();

        return pass;
    }
}