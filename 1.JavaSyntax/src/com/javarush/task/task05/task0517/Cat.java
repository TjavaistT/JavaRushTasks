package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    int age = 1;
    int weight = 3;
    String color = "gray";
    String name;
    String address;

    public static void main(String[] args) {
        Cat cat = new Cat(5, "black", "box");
        System.out.println(cat.name);
        System.out.println(cat.age);
        System.out.println(cat.address);
        System.out.println(cat.weight);
    }

    public Cat(String name){
        this.name = name;
    }

    public Cat(String name, int age){
        this(name);
        this.age = age;
    }

    public Cat(String name, int weight, int age){
        this(name, age);
        this.weight = weight;
    }

    public Cat(int weight, String color){
        this.weight = weight;
        this.color = color;
    }

    public Cat(int weight, String color, String address){
        this(weight, color);
        this.address = address;
    }
}
