package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream oldSystemOut = System.out;

        ByteArrayOutputStream reklama = new ByteArrayOutputStream();

        System.setOut(new PrintStream(reklama));

        testString.printSomething();

        System.setOut(oldSystemOut);

        String[] originalText = reklama.toString().split(System.lineSeparator());

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < originalText.length; i++) {

            if(i % 2 == 0 && i != 0) result.append("JavaRush - курсы Java онлайн").append(System.lineSeparator());

            result.append(originalText[i]);

            if(i != originalText.length-1) result.append(System.lineSeparator());
        }

        System.out.print(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
