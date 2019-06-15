package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
        return a + b;
    }

    public static int minus(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double division(int a, int b) {
        double v = new Double(a)/new Double(b);
        return v;
    }

    public static double percent(int a, int b) {
        double percent = Double.valueOf(b) * Double.valueOf(a)/100;
        return percent;
    }

    public static void main(String[] args) {
    }
}