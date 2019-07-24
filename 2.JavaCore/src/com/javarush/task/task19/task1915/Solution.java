package com.javarush.task.task19.task1915;

import java.io.*;
import java.util.*;
import java.lang.*;
/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        try (
                BufferedReader scanConsole = new BufferedReader(new InputStreamReader(System.in));
                FileOutputStream fileStream = new FileOutputStream(scanConsole.readLine())
        ){
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            PrintStream streamToByteArray = new PrintStream(byteArray);
            PrintStream oldSOUT = System.out;

            System.setOut(streamToByteArray);
            //записать в массив
            testString.printSomething();

            System.setOut(oldSOUT);
            //записать массив в файл
            byteArray.writeTo(fileStream);
            //вывод в консоль
            System.out.println(byteArray);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

