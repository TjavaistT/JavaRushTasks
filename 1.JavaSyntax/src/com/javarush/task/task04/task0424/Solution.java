package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.valueOf(reader.readLine());
        int second = Integer.valueOf(reader.readLine());
        int third = Integer.valueOf(reader.readLine());

        if(first != second && second == third){
            System.out.println(1);
        } else if(second != first && first == third) {
            System.out.println(2);
        } else if(third != first && first == second) {
            System.out.println(3);
        }
    }
}
