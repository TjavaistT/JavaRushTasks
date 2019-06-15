package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    int age = 1;
    int weight = 3;
    String color = "gray";
    String name;
    String address;

    public static void main(String[] args) {

    }

    public void initialize(String name){
        int age = 1;
        int weight = 3;
        String color = "gray";
        this.name = name;
    }

    public void initialize(String name, int weight, int age){
        this.weight = weight;
        this.age = age;
        this.name = name;
    }

    public void initialize(String name, int age){
        this.age = age;
        this.name = name;
    }

    public void initialize(int weight, String color){
        this.weight = weight;
        this.color = color;
    }

    public void initialize(int weight, String color, String address){
        this.weight = weight;
        this.color = color;
        this.address = address;
    }
}
