package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.*;
import java.lang.*;
/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) {
     try(
         BufferedReader consoleBufR = new BufferedReader(new InputStreamReader(System.in));
         BufferedReader fileReader = new BufferedReader(new FileReader(consoleBufR.readLine()));
         BufferedWriter fileWriter = new BufferedWriter(new FileWriter(consoleBufR.readLine()))
         ){
         fileReader.lines()
             .map(element -> element.replaceAll("\\.", "!"))
             .forEach(element -> Solution.writeToFile(fileWriter, element));

         }catch (Exception e){
             e.printStackTrace();
         }
    }
    
    public static void writeToFile(BufferedWriter buf, String strNumber){
        try {
            buf.write(strNumber);
            buf.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
