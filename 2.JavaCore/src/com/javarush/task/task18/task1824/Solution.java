package com.javarush.task.task18.task1824;

import java.io.*;
import java.util.*;
import java.lang.*;
/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {
        String filename = null;
        try (
                Scanner scanConsole = new Scanner(System.in)
        ){
            while (!(filename = scanConsole.nextLine()).equals("")) {
                Scanner scanFile = new Scanner(new BufferedInputStream(new FileInputStream(filename)));
                scanFile.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(filename);
        }
    }
}
