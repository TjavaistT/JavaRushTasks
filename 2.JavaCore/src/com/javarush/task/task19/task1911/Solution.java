package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream oldSystemOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream myStream = new PrintStream(outputStream);

        System.setOut(myStream);

        testString.printSomething();

        System.setOut(oldSystemOut);

        String result = outputStream.toString().toUpperCase();

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
