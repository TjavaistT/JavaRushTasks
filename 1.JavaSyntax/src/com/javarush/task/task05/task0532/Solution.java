package com.javarush.task.task05.task0532;

import java.io.*;

/*
Задача по алгоритмам
*/

public class Solution {
    public  static  int maximum;
    public  static  int count;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        count = Integer.parseInt(line);

        if(count > 0)
        {
            int number = Integer.parseInt(reader.readLine());
            maximum = number;

            for (int i = 0; i < count-1; i++) {
                number = Integer.parseInt(reader.readLine());
                maximum = number > maximum ? number : maximum;
            }

        System.out.println(maximum);
        }

    }
}
