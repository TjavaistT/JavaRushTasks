package com.javarush.task.task12.task1224;

/* 
Неведома зверушка
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        String animal = "";
        //"Кот", "Тигр", "Лев", "Бык", "Животное"
        if (o.getClass() == (new Cat()).getClass()) {
            animal = "Кот";
        } else if(o.getClass() == (new Tiger()).getClass()) {
            animal = "Тигр";
        } else if(o.getClass() == (new Lion()).getClass()) {
            animal = "Лев";
        } else if(o.getClass() == (new Bull()).getClass()) {
            animal = "Бык";
        } else {
            animal = "Животное";
        }

        return animal;
    }

    public static class Cat {
    }

    public static class Tiger {
    }

    public static class Lion {
    }

    public static class Bull {
    }

    public static class Pig {
    }
}
