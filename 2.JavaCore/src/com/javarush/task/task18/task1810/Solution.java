package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s = br.readLine();
            FileInputStream fr = new FileInputStream(s);
            if (fr.available() < 1000){
                fr.close();
                br.close();
                throw new DownloadException();
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
