package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.stream.IntStream;

/* Задача 1531 - просто факториал (+ 1 зя, +1 ам, +1 ор (оптимизация ресурсов))
* но ты ведь можешь круче :)
* или похитрее https://habr.com/ru/post/60306/
*
* ну и знакомство с BigInteger и понимание того какой цикл будет быстрее
*
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        if (n < 0) {
            return new BigInteger(Integer.toString(0)).toString();
        }

        BigInteger result = new BigInteger(Integer.toString(1));

//      Замер времени
//        long start = System.currentTimeMillis();

// данный цикл быстрее - факториал числа 323456 посчитался за 90 сек
        for(int i = 1; i <= n; i++){

// этот медленнее - факториал числа 323456 посчитался за 99 сек + 10%
// если посмотришь в каком порядке числа перемножаются - станет ясно почему
//        int i;
//        for(;n > 0;--n){
//          i = n;

            result = result.multiply(BigInteger.valueOf(i));

        }

//      Замер времени
//        long end = System.currentTimeMillis();
//
//        long diffTime = end-start;
//
//        System.out.println(diffTime/1000);

        return result.toString();
    }
}
