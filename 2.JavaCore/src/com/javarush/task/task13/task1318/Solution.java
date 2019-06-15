package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* Задача 1318
Чтение файла
*/
public class Solution {
    public static void main(String[] args) {
        InputStreamReader readerIS = null;
        BufferedReader reader= null;
        FileInputStream contentFIS = null;
        BufferedInputStream content = null;

        try {
        readerIS = new InputStreamReader(System.in);
        reader = new BufferedReader(readerIS);

        String filePath = reader.readLine();

        contentFIS = new FileInputStream(filePath);
        content = new BufferedInputStream(contentFIS);

        while(content.available() > 0) {
            System.out.print((char)content.read());
        }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                readerIS.close();
                reader.close();
                contentFIS.close();
                content.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}