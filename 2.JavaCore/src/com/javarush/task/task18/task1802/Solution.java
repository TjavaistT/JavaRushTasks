package com.javarush.task.task18.task1802;

import java.io.*;

/* 
Минимальный байт
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
        int currentByte = frider.read();
        int minimumByte = currentByte;
        while (frider.available() > 0){
            currentByte = frider.read();
            if(currentByte < minimumByte){
                minimumByte = currentByte;
            }
        }

        frider.close();
        System.out.println(minimumByte);

    }
}
