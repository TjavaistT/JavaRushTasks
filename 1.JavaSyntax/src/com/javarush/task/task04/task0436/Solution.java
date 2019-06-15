package com.javarush.task.task04.task0436;


/* 
Рисуем прямоугольник
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.valueOf(reader.readLine());
        int n = Integer.valueOf(reader.readLine());
        String line = "";

        for (int i = 0; i < m ; i++) {
            line = "";
            int j = 0;
            for (; j < n; j++) {
                line +=8;
            }
            System.out.println(line);
        }
    }
}
