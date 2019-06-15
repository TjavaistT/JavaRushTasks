package com.javarush.task.task07.task0722;

import java.io.*;
import java.util.*;
import java.lang.*;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        list = initalizeArrayStrings();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static ArrayList<String> initalizeArrayStrings(){
            ArrayList<String> list = new ArrayList<String>();
            Scanner scan = new Scanner(System.in);
            String line;

            for (; true; ){
                line = scan.nextLine();

                if(line.equals("end")){
                    break;
                }

                list.add(line);
            }

            return list;
        }
}