package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<String>(5);
        String temporary;

        for (int i = 0; i < 5; i++){
            lines.add(scan.nextLine());
        }

        for (int i = 0; i < 13; i++) {
            temporary = lines.get(4);
            lines.remove(4);
            lines.add(0, temporary);
        }

        for (String line:lines) {
            System.out.println(line);
        }
    }
}
