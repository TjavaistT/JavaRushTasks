package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 
Статические коты
*/

public class Cat {
    public  static ArrayList<Cat> cats = new ArrayList<>();

    public Cat() {
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            cats.add(new Cat());
        }
        printCats(cats);
    }

    public static void printCats(ArrayList objectsList) {
        for(Object someCat : objectsList) {
            System.out.println(someCat);
        }
    }
}
