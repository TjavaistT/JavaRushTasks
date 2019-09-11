package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringBuilder resultDecode = new StringBuilder();
        if(reader == null) return resultDecode.toString();
        int decodeSymbolInt;

        while ((decodeSymbolInt = reader.read()) > -1){
            decodeSymbolInt = decodeSymbolInt + key;
            char decodeSymbolChar = (char)decodeSymbolInt;
            resultDecode.append(decodeSymbolChar);
        }

        return resultDecode.toString();
    }
}
