package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        float number;
        float summ = 0;
        float count = 0;
        float average = 0;


        while ((number = scan.nextInt()) != -1) {
            count++;
            summ += number;
            average = summ / count;
        }

            System.out.println(average);
    }
}

