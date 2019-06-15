package com.javarush.task.task12.task1225;

/* 
Посетители
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    public static String getObjectType(Object o) {
        String animal = "";
        //"Кот", "Тигр", "Лев", "Бык", "Животное"
        //"Кот", "Тигр", "Лев", "Бык", "Корова", "Животное"
        if (o.getClass() == (new Cat()).getClass()) {
            animal = "Кот";
        } else if(o.getClass() == (new Tiger()).getClass()) {
            animal = "Тигр";
        } else if(o.getClass() == (new Lion()).getClass()) {
            animal = "Лев";
        } else if(o.getClass() == (new Bull()).getClass()) {
            animal = "Бык";
        }  else if(o.getClass() == (new Cow()).getClass()) {
            animal = "Корова";
        } else if(o.getClass() == (new Animal()).getClass()) {
            animal = "Животное";
        }

        return animal;
    }

    public static class Cat extends Animal   //<--Классы наследуются!!
    {
    }

    public static class Tiger extends Cat {
    }

    public static class Lion extends Cat {
    }

    public static class Bull extends Animal {
    }

    public static class Cow extends Animal {
    }

    public static class Animal {
    }
}
