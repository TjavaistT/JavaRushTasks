package com.javarush.task.task15.task1518;

/* 
Статики и котики
*/

public class Solution {
    public static Cat cat;

    static { cat = new Cat();
        cat.initalize("Блохин");
        System.out.println(cat.getName());
    }

    public static void main(String[] args) {

    }

    public static class Cat{
        public String getName() {
            return name;
        }

        public String name;

        public void initalize(String name){
            this.name = name;
        }
    }
}
