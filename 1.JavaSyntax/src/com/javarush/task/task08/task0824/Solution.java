package com.javarush.task.task08.task0824;

/* 0824
Собираем семейство
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        Human child1 = new Human("Лика", false, 18, new ArrayList<Human> ());
        Human child2 = new Human("Вика", false, 13, new ArrayList<Human> ());
        Human child3 = new Human("Ника", false, 7, new ArrayList<Human> ());
        Human mother = new Human("Анастасия", false, 35, new ArrayList<Human> (Arrays.asList(child1, child2, child3)));
        Human father = new Human("Федор", true, 42, new ArrayList<Human> (Arrays.asList(child1, child2, child3)));
        Human grandfather1 = new Human("Поликарп", true, 81, new ArrayList<Human> (Arrays.asList(mother)));
        Human grandfather2 = new Human("Диодох", true, 82, new ArrayList<Human> (Arrays.asList(father)));
        Human grandmother1 = new Human("Аполинарья", false, 85, new ArrayList<Human> (Arrays.asList(mother)));
        Human grandmother2 = new Human("Ариста", false, 86, new ArrayList<Human> (Arrays.asList(father)));

        System.out.println(grandfather1);
        System.out.println(grandfather2);
        System.out.println(grandmother1);
        System.out.println(grandmother2);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human {

        public String name;
        public boolean sex;
        public int age;
        public ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
