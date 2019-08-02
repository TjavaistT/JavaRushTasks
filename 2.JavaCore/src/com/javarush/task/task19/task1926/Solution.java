package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        try (
                BufferedReader scanConsole = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader bufFile =new BufferedReader(new FileReader(scanConsole.readLine()))
        ){
            bufFile.lines()
                .map(line -> new StringBuilder(line).reverse())
                .forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
