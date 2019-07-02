package com.javarush.task.task18.task1801;

import java.io.*;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String filename = "";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            filename = bufferedReader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream frider = new FileInputStream(filename);
        int maximumByte = 0;
        int currentByte = 0;
       while (frider.available() > 0){
           currentByte = frider.read();
            if(currentByte > maximumByte){
                maximumByte = currentByte;
            }
       }

        frider.close();
        System.out.println(maximumByte);

    }
}
