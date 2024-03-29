package com.javarush.task.task14.task1407;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача 1407 - просто разный результат в зависимости от типа переменной
Player and Dancer
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Person person;
        String key;
        while (!(key = reader.readLine()).equals("exit")) {
            if ("player".equals(key)) {
                person = new Player();
                haveFun(person);
            } else if ("dancer".equals(key)) {
                person = new Dancer();
                haveFun(person);
            }
        }
    }

    public static void haveFun(Person person) {
        if(person instanceof Player){
            ((Player) person).play();
        } else if(person instanceof  Dancer){
            ((Dancer) person).dance();
        }
    }

    interface Person {
    }

    static class Player implements Person {
        void play() {
            System.out.println("playing");
        }
    }

    static class Dancer implements Person {
        void dance() {
            System.out.println("dancing");
        }
    }
}