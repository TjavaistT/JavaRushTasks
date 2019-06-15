package com.javarush.task.task04.task0437;

/* 
Треугольник из восьмерок
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        String line = "";

        for (int i = 0; i < 10; i++) {
            line = "";
            for (int j = 0; j <= i; j++) {
                line += "8";
            }
            System.out.println(line);
        }
    }
}
