package com.javarush.task.task05.task0504;


/* 
Трикотаж
*/

public class Solution {
    public static void main(String[] args) {
        Cat Vaska = new Cat("Vaska", 2, 3, 4);
        Cat Murzik = new Cat("Murzik", 3, 4, 5);
        Cat Murka = new Cat("Murka", 1, 2, 1);
    }

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }
    }
}