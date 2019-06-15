package com.javarush.task.task06.task0606;

import java.io.*;
import java.util.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        if(scan.hasNextInt()){
            int number = scan.nextInt();
            while (number !=0 ){
                //получить последнюю цифру
                int symbol = number % 10;
                if (symbol % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
                // уменьшить число на 1 цифру - так как тип целочисленный, то цифра
                // после запятой автоматически отбросится сама без округления
                number = number/10;

            }
            System.out.println("Even: " + even + " Odd: " + odd);
        }
    }
}
