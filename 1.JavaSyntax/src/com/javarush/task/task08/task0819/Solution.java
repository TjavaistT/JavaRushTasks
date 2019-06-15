package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        Iterator catsIterartor = cats.iterator();

        cats.remove(catsIterartor.next());

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        Set<Cat> cats = new HashSet();
        cats.add(new Cat());
        cats.add(new Cat());
        cats.add(new Cat());

//        cats.add(new Cat("Черчиль"));
//        cats.add(new Cat("Рузвельт"));
//        cats.add(new Cat("Сталин"));

        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        cats.forEach(System.out::println);
    }

    public static class Cat{

        String name;

        public Cat(){};

        public Cat(String name){
            this.name = name;
        }

//        public String toString(){
//            return "Cat - " + this.name;
//        }
    }
}
