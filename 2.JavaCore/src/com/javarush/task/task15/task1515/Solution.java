package com.javarush.task.task15.task1515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Задача 1515 - что-то новенькое :) - статические блоки
Статики-2
*/
public class Solution {
    public static int A;
    public static int B;

    //Статические блоки это куски кода, которые выполняются при инициализации статических переменных, но до вызова конструктора
    //применяются если для запуска класса нужно что-то совершить - к БД подключится, из файла что-то считать, на сервер постучаться
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            A = (int) Integer.parseInt(reader.readLine());
            B = (int) Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //! Важно расположение статического блока и порядок вызова методов! MIN - должен быть после стат.блока
    public static final int MIN = min(A, B);

    public static void main(String[] args) {
        System.out.println(MIN);
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}
