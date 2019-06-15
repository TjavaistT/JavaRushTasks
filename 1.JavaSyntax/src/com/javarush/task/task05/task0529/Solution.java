package com.javarush.task.task05.task0529;

import java.io.*;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int number = 0;
        int summ = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        while(!line.equals("сумма")){
            try {
                number = Integer.valueOf(line);
            } catch (Exception except) {

            }
            summ += number;
            line = reader.readLine();
        }

        System.out.println(summ);
    }
}
