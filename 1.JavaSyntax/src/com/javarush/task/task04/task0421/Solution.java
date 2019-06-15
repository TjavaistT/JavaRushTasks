package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String first = reader.readLine();
        String second = reader.readLine();

        if(first.equals(second)){
            System.out.println("Имена идентичны");
        }else if(first.length() == second.length()){
            System.out.println("Длины имен равны");
        }
    }
}
