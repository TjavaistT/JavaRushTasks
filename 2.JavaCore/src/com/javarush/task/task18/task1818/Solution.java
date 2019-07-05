package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try(Scanner scan = new Scanner(System.in)){

            String filenameFirst = scan.nextLine();
            String filenameSecond = scan.nextLine();
            String filenameThird = scan.nextLine();


            try (
                    FileOutputStream fileOutFirstStream = new FileOutputStream(filenameFirst, true);
                    FileInputStream fileInSecondStream = new FileInputStream(filenameSecond);
                    FileInputStream fileInThirdStream = new FileInputStream(filenameThird);
                ){

                byte[] contentsSecondFile = new byte[fileInSecondStream.available()];
                byte[] contentsThirdFile = new byte[fileInThirdStream.available()];

                fileInSecondStream.read(contentsSecondFile);
                fileInThirdStream.read(contentsThirdFile);

                fileOutFirstStream.write(contentsSecondFile);
//                fileOutFirstStream.write((byte) '\n');
                fileOutFirstStream.write(contentsThirdFile);


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
