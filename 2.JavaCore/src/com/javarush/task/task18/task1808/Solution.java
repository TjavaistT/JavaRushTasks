package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        String parentFile = null;
        String childFileFirst = null;
        String childFileSecond = null;

        try (Scanner scan = new Scanner(System.in)){
            parentFile = scan.nextLine();
            childFileFirst = scan.nextLine();
            childFileSecond = scan.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        assert parentFile != null;
        assert childFileFirst != null;
        assert childFileSecond != null;
        try (FileInputStream fileImpStr = new FileInputStream(parentFile);
             FileOutputStream fileOutputStreamOne = new FileOutputStream(childFileFirst);
             FileOutputStream fileOutputStreamTwo = new FileOutputStream(childFileSecond);
        ){
            byte[] bytes = new byte[fileImpStr.available()];

            //массив bytes передается по ссылке и заполняется, (+1 зя)
            // а результатом работы функции является число - количество считанных байт
            //запомнить бы - это очень путает
            int countBytes = fileImpStr.read(bytes);

            //округление вверх введено для того чтобы в первом файле оказалось больше байт
            int half = (int) Math.ceil(Double.valueOf(countBytes)/2);

            fileOutputStreamOne.write(bytes, 0, half);

            //для приведения к int, десятичные числа округляются вниз
            fileOutputStreamTwo.write(bytes, half, countBytes - half);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
