package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        Man Petr = new Man("Petya", 20, "Moscow");
        Man Slava = new Man("Viacheslav", 18, "Rostov");
        System.out.println(Petr);
        System.out.println(Slava);

        Woman Alisa = new Woman("Alica", 17, "Moscow");
        Woman Arina = new Woman("Arina", 25, "Rostov");
        System.out.println(Alisa);
        System.out.println(Arina);
    }

    public static class Man{
        String name;
        int age;
        String address;

        public Man(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }

        @Override
        public String toString() {
            return this.name + " " + this.age + " " + this.address;
        }
    }

    public static class Woman{
        String name;
        int age;
        String address;

        public Woman(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }

        @Override
        public String toString() {
            return this.name + " " + this.age + " " + this.address;
        }
    }
}
