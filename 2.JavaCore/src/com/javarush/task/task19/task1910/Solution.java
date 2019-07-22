package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.*;
import java.lang.*;
/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) {
        try(
            BufferedReader consoleBufR = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader(consoleBufR.readLine()));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(consoleBufR.readLine()))
            ){
            fileReader.lines()
                .map(line -> line.replaceAll("\\p{P}+", ""))
                .forEach(element -> Solution.writeToFile(fileWriter, element));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void writeToFile(BufferedWriter buf, String str){
        try {
            buf.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
