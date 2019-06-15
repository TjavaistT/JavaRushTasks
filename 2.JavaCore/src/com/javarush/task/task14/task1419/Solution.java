package com.javarush.task.task14.task1419;

import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        exceptions.add(new NullPointerException());
        exceptions.add(new ArrayIndexOutOfBoundsException());
        exceptions.add(new ClassCastException());
        exceptions.add(new ClassNotFoundException());

        exceptions.add(new NegativeArraySizeException());
        exceptions.add(new NamingException());
        exceptions.add(new RuntimeException());
        exceptions.add(new NoSuchFieldException());
        exceptions.add(new NumberFormatException());

    }
}
