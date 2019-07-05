package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String fileFirst = null;
        String fileSecond = null;

        try (Scanner scan = new Scanner(System.in)){
            fileFirst = scan.nextLine();
            fileSecond = scan.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        assert fileFirst != null;
        assert fileSecond != null;

        try (FileInputStream fileImpStream = new FileInputStream(fileFirst);
             FileOutputStream fileOutputStream = new FileOutputStream(fileSecond);
        ){
            byte[] bytes = new byte[fileImpStream.available()];

            int countBytes = fileImpStream.read(bytes);

            for (int i = countBytes-1; i >= 0; i--) {
                fileOutputStream.write(bytes[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
