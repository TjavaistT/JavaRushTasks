package com.javarush.task.task05.task0511;

/* 
Создать класс Dog
*/

public class Dog {
    String name;
    int height;
    String color;

    public static void main(String[] args) {

    }

    public void initialize(String name){
        this.name = name;
    }

    public void initialize(String name, int height){
        this.initialize(name);
        this.height = height;
    }

    public void initialize(String name, int height, String color){
        this.initialize(name, height);
        this.color = color;
    }
}
