package com.javarush.task.task18.task1826;

import java.io.*;
import java.lang.*;
/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) {
//        Э: определить направление - шифровка/дешифровка
        boolean encript = args[0].equals("-e");
        boolean decript = args[0].equals("-d");
        String  fileReadName = args[1];
        String  fileWriteName = args[2];

        try (
            FileInputStream fileInpStream = new FileInputStream(fileReadName);
            FileOutputStream fileOutStream = new FileOutputStream(fileWriteName)
        ){
            if (encript) {
                encripted(fileInpStream, fileOutStream);
            }

            if (decript) {
                decripted(fileInpStream, fileOutStream);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void encripted(FileInputStream readedFile, FileOutputStream writedFile) throws IOException {
        byte[] data = readFromFile(readedFile);
        byte[] encriptedData = encriptData(data);
        writeTofile(writedFile, encriptedData);
    }

    private static void decripted(FileInputStream readedFile, FileOutputStream writedFile) throws IOException {
        byte[] data = readFromFile(readedFile);
        byte[] decriptedData = decriptData(data);
        writeTofile(writedFile, decriptedData);
    }

    private static byte[] encriptData(byte[] data) {

        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) (data[i] + (byte)1);
        }

        return data;
    }

    private static byte[] decriptData(byte[] data) {

        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) (data[i] - (byte)1);
        }

        return data;
    }

    private static byte[] readFromFile(FileInputStream readedFile) throws IOException {
        byte[] contentFile = new byte[readedFile.available()];
        readedFile.read(contentFile);
        return contentFile;
    }

    private static void writeTofile(FileOutputStream writedFile, byte[] data) throws IOException {
        writedFile.write(data);
    }

}
