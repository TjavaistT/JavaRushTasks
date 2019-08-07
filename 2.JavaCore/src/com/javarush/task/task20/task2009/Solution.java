package com.javarush.task.task20.task2009;

import java.io.Serializable;

/* Задача 2009 - статические пол не сериализуются - (они ведь к классу относятся, а не к объекту)
* их можно сериализовать вручную с помощью интерфейса Externalizable
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;
    }

    public static void main(String[] args) {

    }
}
