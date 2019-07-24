package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleSave = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleSave);

        List<String> elementsExamples = new ArrayList<>();
        String line = outputStream.toString();
        Matcher m = Pattern.compile("\\d+|\\+|\\*|-").matcher(line);

        while (m.find()){
            elementsExamples.add(m.group());
        }

        int a = Integer.parseInt(elementsExamples.get(0));
        int b = Integer.parseInt(elementsExamples.get(2));
        String operator = elementsExamples.get(1);
        int result = 0;

        switch (operator){
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result =  a * b;
                break;
        }

        System.out.printf("%d %s %d = %d", a, operator, b, result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

