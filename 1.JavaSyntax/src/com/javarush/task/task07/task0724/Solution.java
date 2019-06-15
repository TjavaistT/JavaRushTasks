package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human grandFather1 = new  Human("Леонид", true, 82);
        Human grandMother1 = new  Human("Алла", false, 80);
        Human grandFather2 = new  Human("Пафнутий", true, 86);
        Human grandMother2 = new  Human("Пелагея", false, 81);
        Human Father = new  Human("Андрей", true, 57, grandFather1, grandMother1);
        Human Mother = new  Human("Екатерина", false, 51, grandFather2, grandMother2);
        Human Child1 = new  Human("Леша", true, 34, Father, Mother);
        Human Child2 = new  Human("Ксюша", false, 17, Father, Mother);
        Human Child3 = new  Human("Игорек", true, 8, Father, Mother);

        System.out.println(grandFather1);
        System.out.println(grandFather2);
        System.out.println(grandMother1);
        System.out.println(grandMother2);
        System.out.println(Father);
        System.out.println(Mother);
        System.out.println(Child1);
        System.out.println(Child2);
        System.out.println(Child3);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, boolean sex, int age, Human father, Human mother){
            this(name, sex, age);
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}