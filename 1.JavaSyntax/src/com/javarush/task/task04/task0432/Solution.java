package com.javarush.task.task04.task0432;

/* 
Хорошего много не бывает
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int number = Integer.valueOf(reader.readLine());
        int i = 1;

        while (i <= number){
            System.out.println(line);
            i++;
        }
    }
}
