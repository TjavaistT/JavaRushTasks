package com.javarush.task.task05.task0509;

/* 
Создать класс Friend
*/

public class Friend {
    String name;
    int age;
    char sex;

    public static void main(String[] args) {

    }

    public void initialize(String name){
        this.name = name;
    }

    public void initialize(String name, int age){
        this.initialize(name);
        this.age = age;
    }

    public void initialize(String name, int age, char sex){
        this.initialize(name, age);
        this.sex = sex;
    }
}
